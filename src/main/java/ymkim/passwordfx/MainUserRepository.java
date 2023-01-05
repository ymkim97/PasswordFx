package ymkim.passwordfx;

public class MainUserRepository {
    private String MainUsername;
    private String latestInfo = "";

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

}
