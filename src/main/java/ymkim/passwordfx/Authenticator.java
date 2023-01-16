package ymkim.passwordfx;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class Authenticator {
    private Cipher cipher;
    private SecretKeySpec keySpec;
    private IvParameterSpec ivParameterSpec;

    public Authenticator() throws Exception{
        String alg = "AES/CBC/PKCS5Padding";
        String key = "73869011290132490853472803203527";
        String iv = key.substring(0, 16);

        cipher = Cipher.getInstance(alg);
        keySpec = new SecretKeySpec(key.getBytes(), "AES");
        ivParameterSpec = new IvParameterSpec(iv.getBytes());
    }

    public String encrypt(String text) throws Exception {
        cipher.init(Cipher.ENCRYPT_MODE, keySpec, ivParameterSpec);

        byte[] encrypted = cipher.doFinal(text.getBytes("UTF-8"));
        return Base64.getEncoder().encodeToString(encrypted);
    }

    public String decrypt(String cipherText) throws Exception {
        cipher.init(Cipher.DECRYPT_MODE, keySpec, ivParameterSpec);

        byte[] decodedBytes = Base64.getDecoder().decode(cipherText);
        byte[] decrypted = cipher.doFinal(decodedBytes);
        return new String(decrypted, "UTF-8");
    }

}
