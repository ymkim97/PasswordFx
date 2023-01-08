package ymkim.passwordfx;

public class MainUserRepository {
    private String MainUsername;
    private String latestInfo = "";
    private int modifyInfoNumber;
    private String modifiedName;

    public void setMainUsername(String MainUsernameInput) {
        this.MainUsername = MainUsernameInput;
    }

    public String getMainUsername() {
        return this.MainUsername;
    }

    public void setLatestInfo(String latestInfo) {
        this.latestInfo = latestInfo;
    }

    public String getLatestInfo() {
        return this.latestInfo;
    }

    public void setModifyInfoNumber(int infoNumber) {
        this.modifyInfoNumber = infoNumber;
    }

    public int getModifyInfoNumber() {
        return this.modifyInfoNumber;
    }

    public void setModifiedName(String name) {
        this.modifiedName = name;
    }

    public String getModifiedName() {
        return this.modifiedName;
    }

}
