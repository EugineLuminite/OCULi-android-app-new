package oculimobile.oculi;
import com.google.gson.annotations.SerializedName;

public class LoginChallenge
{
    @SerializedName("Log")
    public String mLog;
    @SerializedName("Username")
    public String mUsername;
    @SerializedName("Password")
    public String mPassword;

    public String getLog() {
        return mLog;
    }
    public final void setLog(String text) {
        mLog = text;
    }

    public String getmUsername() {
        return mUsername;
    }
    public final void setmUsername(String text) {
        mUsername = text;
    }

    public String getmPassword() { return mPassword;
    }
    public final void setmPassword(String text) {
        mPassword = text;
    }
}
