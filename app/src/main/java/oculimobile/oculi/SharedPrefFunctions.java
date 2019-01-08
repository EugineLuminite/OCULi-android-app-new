package oculimobile.oculi;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.content.Context;

import oculimobile.oculi.ObjectsToUse.CustomLoginResult;

public class SharedPrefFunctions
{
    private static final String SAVESETTINGS ="nastroiki_settings";
    private static final String SHAREDPREFFILE = "temp";
    private static final String USERIDPREF = "uid";
    private static final String TOKENMAIN = "tkn";
    private static final String TOKEN_REFRESH = "tknref";
    private static final String TOKENVALIDDATE = "tknvalid";
    private Context mcontext ;
//    {
//            "userId": "string",
//            "mobileServiceAuthenticationToken": "string",
//            "tokenRefreshSecret": "string",
//            "tokenValidDate": "string"
//    }



    public SharedPrefFunctions(Context _mcontext)
    {
        //customLoginResult= new CustomLoginResult();
        mcontext = _mcontext;
    }
    public void CallPreference_set(boolean val)
    {
        SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(mcontext);
        SharedPreferences.Editor editor = settings.edit();
        editor.putBoolean("callbuttons", val);
        editor.commit();

    }
    public boolean SetSharedPreferences(String mUSERIDPREF, String mTOKENMAIN,String mTOKEN_REFRESH,String mTOKENVALIDDATE)
    {
        SharedPreferences prefs = mcontext.getSharedPreferences(SHAREDPREFFILE, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString(USERIDPREF, mUSERIDPREF);
        editor.putString(TOKENMAIN, mTOKENMAIN);
        editor.putString(TOKEN_REFRESH, mTOKEN_REFRESH);
        editor.putString(TOKENVALIDDATE, mTOKENVALIDDATE);
        editor.commit();
        return true;
    }
    public boolean CallPreference_Load()
    {
        SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(mcontext);
        boolean val = settings.getBoolean("callbuttons",true);
        return val ;
    }
    public boolean CallAnyBool_settings(String name)
    {
        SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(mcontext);
        boolean val = settings.getBoolean(name,false);
        return val ;
    }
//    private String TestPreference_load()
//    {
//        SharedPreferences SP = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
//        String Appkey = SP.getString("AppSecurityKeyValue","");
//        return Appkey;
//    }
//    private String GetAnyStringMemmoryValye(String value)
//    {
//        SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
//        String val = settings.getString(value,"");
//        return  val;
//    }

    public boolean DeleteUser()
    {
        try
        {
            SharedPreferences prefs = mcontext.getSharedPreferences(SHAREDPREFFILE, Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = prefs.edit();
            editor.putString(USERIDPREF, "");
            editor.putString(TOKENMAIN, "");
            editor.putString(TOKEN_REFRESH, "");
            editor.putString(TOKENVALIDDATE, "");
            editor.commit();
            return true;

        }
        catch (Exception ex)
        {
            return  false;
        }
    }
    public boolean CheckUser_LoadSharedPreferences()
    {
        boolean TruFalse = true;
        SharedPreferences prefs = mcontext.getSharedPreferences(SHAREDPREFFILE, Context.MODE_PRIVATE);
        String userId = prefs.getString(USERIDPREF, null);
        if (userId == "" || userId == null)
        {
            return false;
        }
        String token = prefs.getString(TOKENMAIN, null);
        if (token == "" || token == null)
        {
            return false;
        }

        return TruFalse;
    }

    public CustomLoginResult LoadSharedPreferences()
    {
        boolean TruFalse = true;
        SharedPreferences prefs = mcontext.getSharedPreferences(SHAREDPREFFILE, Context.MODE_PRIVATE);
        String userId = prefs.getString(USERIDPREF, null);
        if (userId == "" || userId == null) {
            TruFalse = false;
        }
        String token = prefs.getString(TOKENMAIN, null);
        if (token == "" || token == null) {
            TruFalse = false;
        }
        if (TruFalse)
        {

            try
            {
               return new CustomLoginResult(userId,token);
                //customLoginResult.setUserId(userId);
                //customLoginResult.setMobileServiceAuthenticationToken(token);
            }
            catch (Exception e)
            {
               return null;
                // maketoast(e.toString());
            }

        }


        return null;
    }

}
