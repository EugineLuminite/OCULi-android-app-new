package oculimobile.oculi.ObjectsToUse;

public class CustomLoginResult
{
    private String UserId ;
    private String MobileServiceAuthenticationToken ;

    /**
     * CustomLoginResult constructor
     */
    public CustomLoginResult()
    {

    }
    public CustomLoginResult(String user,String key)
    {
        this.setUserId(user);
        this.setMobileServiceAuthenticationToken(key);
    }
    public String getUserId()
    {return  UserId;}
    public String getMobileServiceAuthenticationToken()
    {return MobileServiceAuthenticationToken;}

    public  void setUserId(String userid)
    {
        UserId= userid;
    }
    public void setMobileServiceAuthenticationToken(String mobileserviceauthenticationtoken)
    {
        MobileServiceAuthenticationToken = mobileserviceauthenticationtoken;
    }

}

