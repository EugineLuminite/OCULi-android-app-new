package oculimobile.oculi.ObjectsToUse;

import java.util.Date;

public class Site
{
    @com.google.gson.annotations.SerializedName("ID")
    public int mID 			;
    @com.google.gson.annotations.SerializedName("AccountNumber")
    public int mAccountNumber;
    @com.google.gson.annotations.SerializedName("name")
    public String mName 		;
    @com.google.gson.annotations.SerializedName("Line1")
    public String mLine1 	;
    @com.google.gson.annotations.SerializedName("Line2")
    public String mLine2 	;
    @com.google.gson.annotations.SerializedName("Town")
    public String mTown 		;
    @com.google.gson.annotations.SerializedName("City")
    public String mCity 		;
    @com.google.gson.annotations.SerializedName("PostCode")
    public String mPostCode  ;
    @com.google.gson.annotations.SerializedName("Phone")
    public String mPhone 	;
    @com.google.gson.annotations.SerializedName("email")
    public String mEmail	    ;
    @com.google.gson.annotations.SerializedName("County")
    public String mCounty	;
    @com.google.gson.annotations.SerializedName("installDate")
    public String mInstallDate;
    @com.google.gson.annotations.SerializedName("AlertEmails")
    public String mAlertEmails;
    @com.google.gson.annotations.SerializedName("SunOnTime")
    public String mSunOnTime 	;
    @com.google.gson.annotations.SerializedName("SunOffTime")
    public String mSunOffTime 	;
    @com.google.gson.annotations.SerializedName("MonOnTime")
    public String mMonOnTime 	;
    @com.google.gson.annotations.SerializedName("MonOffTime")
    public String mMonOffTime	;
    @com.google.gson.annotations.SerializedName("TueOnTime")
    public String mTueOnTime 	;
    @com.google.gson.annotations.SerializedName("TueOffTime")
    public String mTueOffTime	;
    @com.google.gson.annotations.SerializedName("WedOnTime")
    public String mWedOnTime	;
    @com.google.gson.annotations.SerializedName("WedOffTime")
    public String mWedOffTime	;
    @com.google.gson.annotations.SerializedName("ThuOnTime")
    public String mThuOnTime	;
    @com.google.gson.annotations.SerializedName("ThuOffTime")
    public String mThuOffTime 	;
    @com.google.gson.annotations.SerializedName("FriOnTime")
    public String mFriOnTime 	;
    @com.google.gson.annotations.SerializedName("FriOffTime")
    public String mFriOffTime	;
    @com.google.gson.annotations.SerializedName("SatOnTime")
    public String mSatOnTime 	;
    @com.google.gson.annotations.SerializedName("SatOffTime")
    public String mSatOffTime	;
    @com.google.gson.annotations.SerializedName("OperatorsList")
    public String mOperatorsList ;


    public final void setID(int ID)						       { mID		      =ID		       ; }
    public final void setAccountNumber(int AccountNumber)      { mAccountNumber=AccountNumber ; }
    public final void setName(String Name)		   		       { mName 		  =Name 		   ; }
    public final void setLine1(String Line1)   			       { mLine1 		  =Line1 		   ; }
    public final void setLine2(String Line2)  			       { mLine2 		  =Line2 		   ; }
    public final void setTown(String Town)   			       { mTown		  	=Town		   ; }
    public final void setCity(String City)   			       { mCity 		  =City 		   ; }
    public final void setPostCode(String PostCode)   	       { mPostCode 	  =PostCode 	   ; }
    public final void setPhone(String Phone)   			       { mPhone 		  =Phone 	   ; }
    public final void setEmail(String Email)   			       { mEmail	      =Email	       ; }
    public final void setCounty(String County)   		       { mCounty	  =County		   ; }
    public final void setInstallDate(String InstallDate)         { mInstallDate  =InstallDate   ; }
    public final void setAlertEmails(String AlertEmails)       { mAlertEmails  =AlertEmails   ; }
    public final void setSunOnTime(String SunOnTime )          { mSunOnTime    =SunOnTime     ; }
    public final void setSunOffTime(String SunOffTime )        { mSunOffTime  =SunOffTime    ; }
    public final void setMonOnTime(String MonOnTime )          { mMonOnTime    =MonOnTime     ; }
    public final void setMonOffTime(String MonOffTime)         { mMonOffTime   =MonOffTime    ; }
    public final void setTueOnTime(String TueOnTime )          { mTueOnTime    =TueOnTime     ; }
    public final void setTueOffTime(String TueOffTime)         { mTueOffTime   =TueOffTime    ; }
    public final void setWedOnTime(String WedOnTime)           { mWedOnTime    =WedOnTime     ; }
    public final void setWedOffTime(String WedOffTime)         { mWedOffTime   =WedOffTime    ; }
    public final void setThuOnTime(String ThuOnTime)           { mThuOnTime	   =ThuOnTime   ; }
    public final void setThuOffTime(String ThuOffTime)         { mThuOffTime   =ThuOffTime    ; }
    public final void setFriOnTime(String FriOnTime)           { mFriOnTime    =FriOnTime     ; }
    public final void setFriOffTime(String FriOffTime)         { mFriOffTime   =FriOffTime    ; }
    public final void setSatOnTime(String SatOnTime)           { mSatOnTime    =SatOnTime     ; }
    public final void setSatOffTime(String SatOffTime)         { mSatOffTime   =SatOffTime    ; }
    public final void setOperatorsList(String OperatorsList)   { mOperatorsList=OperatorsList ; }

    public int getID(){return mID;};
    public int getAccountNumber(){ return mAccountNumber;};
    public String getName(){return mName;};
    public String getLine1(){return mLine1;};
    public String getLine2(){return mLine2;};
    public String getTown(){return mTown;};
    public String getCity(){return mCity;};
    public String getPostCode(){return mPostCode;};
    public String getPhone(){return mPhone;};
    public String getEmail(){return mEmail;};
    public String getCounty(){return mCounty;};
    public String getInstallDate (){return mInstallDate;};
    public String getAlertEmails(){return mAlertEmails;};
    public String getSunOnTime (){return mSunOnTime ;};
    public String getSunOffTime(){return mSunOffTime;};
    public String getMonOnTime (){return mMonOnTime ;};
    public String getMonOffTime(){return mMonOffTime;};
    public String getTueOnTime (){return mTueOnTime ;};
    public String getTueOffTime(){return mTueOffTime;};
    public String getWedOnTime (){return mWedOnTime ;};
    public String getWedOffTime(){return mWedOffTime;};
    public String getThuOnTime (){return mThuOnTime ;};
    public String getThuOffTime(){return mThuOffTime;};
    public String getFriOnTime (){return mFriOnTime ;};
    public String getFriOffTime(){return mFriOffTime;};
    public String getSatOnTime (){return mSatOnTime ;};
    public String getSatOffTime(){return mSatOffTime;};
    public String getOperatorsList(){return mOperatorsList;};

    public Site()
    {
    };
    public Site(int ID,int AccountNumber,String Name,String Line1,String Line2,String Town,String City,
                String PostCode,
                String Phone,
                String Email,
                String County,
                Date InstallDate,
                String AlertEmails,
                String SunOnTime,
                String SunOffTime,
                String MonOnTime,
                String MonOffTime,
                String TueOnTime,
                String TueOffTime,
                String WedOnTime,
                String WedOffTime,
                String ThuOnTime,
                String ThuOffTime,
                String FriOnTime,
                String FriOffTime,
                String SatOnTime,
                String SatOffTime,
                String OperatorsList)
    {
        setName(Name);
        setLine1(Line1)   			    ;
        setLine2(Line2)  			    ;
        setTown(Town)   			    ;
        setCity(City)   			    ;
        setPostCode(PostCode)   	    ;
        setPhone(Phone)   			    ;
        setEmail(Email)   			    ;
        setCounty(County)   		    ;
        //setInstallDate(nstallDate)    ;
        setAlertEmails(AlertEmails)     ;
        setSunOnTime(SunOnTime )        ;
        setSunOffTime(SunOffTime )      ;
        setMonOnTime(MonOnTime )        ;
        setMonOffTime(MonOffTime)       ;
        setTueOnTime(TueOnTime )        ;
        setTueOffTime(TueOffTime)       ;
        setWedOnTime(WedOnTime)         ;
        setWedOffTime(WedOffTime)       ;
        setThuOnTime(ThuOnTime)         ;
        setThuOffTime(ThuOffTime)       ;
        setFriOnTime(FriOnTime)         ;
        setFriOffTime(FriOffTime)       ;
        setSatOnTime(SatOnTime)         ;
        setSatOffTime(SatOffTime)       ;
        setOperatorsList(OperatorsList) ;
    }
}

