package oculimobile.oculi.ObjectsToUse;

public class Units
{

    @com.google.gson.annotations.SerializedName("id")
    private int mID;
    @com.google.gson.annotations.SerializedName("name")
    private String mName;
    @com.google.gson.annotations.SerializedName("siteID")
    private int mSiteID;
    @com.google.gson.annotations.SerializedName("siteName")
    private String mSiteName;
    @com.google.gson.annotations.SerializedName("simID")
    private String mSimID;
    @com.google.gson.annotations.SerializedName("fwVersion")
    private String mFWVersion ;
    @com.google.gson.annotations.SerializedName("unitType")
    private String mUnitType;
    @com.google.gson.annotations.SerializedName("lastContact")
    private String mLastContact;
    @com.google.gson.annotations.SerializedName("heartBeat")
    private String mHearBeat;
    @com.google.gson.annotations.SerializedName("totalPower")
    private int mTotalPower;
    @com.google.gson.annotations.SerializedName("batteryChanged")
    private int mBatteryChanged;
    @com.google.gson.annotations.SerializedName("lastPower")
    public int mLastPower ;
    @com.google.gson.annotations.SerializedName("thisMonth")
    public int mThisMonth ;
    @com.google.gson.annotations.SerializedName("dataThisMonth")
    public int mDataThisMonth ;
    @com.google.gson.annotations.SerializedName("dataLastMonth")
    public int mDataLastMonth ;
    @com.google.gson.annotations.SerializedName("dataAllowance")
    public int mDataAllowance ;
    @com.google.gson.annotations.SerializedName("lastBatteryChange")
    public String mLastBatteryChange;
    @com.google.gson.annotations.SerializedName("batteryType")
    public int mBatteryType;
    @com.google.gson.annotations.SerializedName("newBattery")
    public Boolean mNewBattery;
    @com.google.gson.annotations.SerializedName("timeLine")
    public Boolean mTimeLine;
    @com.google.gson.annotations.SerializedName("pir_id")
    public long mPIR_ID;
    @com.google.gson.annotations.SerializedName("camera_ID")
    public long mCamera_ID;
    @com.google.gson.annotations.SerializedName("mac")
    public long mMAC;
    @com.google.gson.annotations.SerializedName("operator")
    public String mOperator;
    @com.google.gson.annotations.SerializedName("voiceTwoWay")
    public Boolean mVoiceTwoWay;
    @com.google.gson.annotations.SerializedName("catchDayNight")
    public Boolean mCatchDayNight;
    @com.google.gson.annotations.SerializedName("dayNightThreshold")
    public int mDayNightThreshold;


    public Units()
    {
    }

    public String getmSiteName() {
        return mSiteName;
    }
    public int getID() {
        return mID;
    }
    public final void setID(int ID) {
        mID = ID;
    }
    public String getName() {
        return mName;
    }
    public final void setName(String ID) {
        mName = ID;
    }
    public int getSiteID() {
        return mSiteID;
    }
    public final void setSiteID(int ID) {
        mSiteID = ID;
    }
    public String getSimID() {
        return mSimID;
    }
    public final void setSiteName(String ID) {
        mSiteName = ID;
    }

    public final void setSimID(String ID) {
        mSimID = ID;
    }
    public String getFWVersion() {
        return mFWVersion;
    }
    public final void setFWVersion(String ID) {
        mFWVersion = ID;
    }
    public String getUnitType() {
        return mUnitType;
    }
    public final void setUnitType(String ID) {
        mUnitType = ID;
    }
    public String getLastContact() {
        return mLastContact;
    }
    public final void setLastContact(String ID) {
        mLastContact = ID;
    }
    public String getHearBeat() {
        return mHearBeat;
    }
    public final void setHearBeat(String  ID) {
        mHearBeat = ID;
    }
    public int getTotalPower() {
        return mTotalPower;
    }
    public final void setTotalPower(int ID) {
        mTotalPower = ID;
    }
    public int getBatteryChanged() {
        return mBatteryChanged;
    }
    public final void setBatteryChanged(int ID) {
        mBatteryChanged = ID;
    }
    public int getLastPower() {
        return mLastPower;
    }
    public final void setLastPower(int ID) {
        mLastPower = ID;
    }
    public int getThisMonth() {
        return mThisMonth;
    }
    public final void setThisMonth(int ID) {
        mThisMonth = ID;
    }
    public int getDataThisMonth() {
        return mDataThisMonth;
    }
    public final void setDataThisMonth(int ID) {
        mDataThisMonth = ID;
    }
    public int getDataLastMonth() {
        return mDataLastMonth;
    }
    public final void setDataLastMonth(int ID) {
        mDataLastMonth = ID;
    }
    public int getDataAllowance() {
        return mDataAllowance;
    }
    public final void setDataAllowance(int ID) {
        mDataAllowance = ID;
    }
    public String getLastBatteryChange() {
        return mLastBatteryChange;
    }
    public final void setLastBatteryChange(String ID) {
        mLastBatteryChange = ID;
    }
    public int getBatteryType() {return mID;}
    public final void setBatteryType(int ID) {
        mBatteryType = ID;
    }
    public boolean getNewBattery() {
        return mNewBattery;
    }
    public final void setNewBattery(boolean ID) {
        mNewBattery = ID;
    }
    public boolean getTimeLine() {
        return mTimeLine;
    }
    public final void setTimeLine(boolean ID) {
        mTimeLine = ID;
    }
    public long getPIR_ID() {
        return mPIR_ID;
    }
    public final void setPIR_ID(long ID) {
        mPIR_ID = ID;
    }
    public long getCamera_ID() {
        return mCamera_ID;
    }
    public final void setCamera_ID(long ID) {
        mCamera_ID = ID;
    }
    public long getMAC() {
        return mMAC;
    }
    public final void setMAC(long ID) {
        mMAC = ID;
    }
    public String getOperator() {
        return mOperator;
    }
    public final void setOperator(String ID) {
        mOperator = ID;
    }
    public boolean getVoiceTwoWay() {
        return mVoiceTwoWay;
    }
    public final void setVoiceTwoWay(boolean ID) {
        mVoiceTwoWay = ID;
    }
    public boolean getCatchDayNight() {
        return mCatchDayNight;
    }
    public final void setCatchDayNight(boolean ID) {
        mCatchDayNight = ID;
    }
    public int getDayNightThreshold() {
        return mDayNightThreshold;
    }
    public final void setDayNightThreshold(int ID) {
        mDayNightThreshold = ID;
    }



    public Units(int 	ID  	 				,
                 String  Name				     ,
                 int     SiteID			      ,
                 String  SiteName,
                 String  SimID			          ,
                 String  FWVersion			     ,
                 String  UnitType			      ,
                 String    LastContact		      ,
                 String  HearBeat			      ,
                 int     TotalPower		     ,
                 int     BatteryChanged	     ,
                 int     LastPower			     ,
                 int     ThisMonth			     ,
                 int     DataThisMonth		     ,
                 int     DataLastMonth		     ,
                 int     DataAllowance		     ,
                 String    LastBatteryChange      ,
                 int     BatteryType		     ,
                 boolean NewBattery		      ,
                 boolean TimeLine			      ,
                 long    PIR_ID			      ,
                 long    Camera_ID			      ,
                 long    MAC				      ,
                 String  Operator			     ,
                 boolean VoiceTwoWay		     ,
                 boolean CatchDayNight		     ,
                 int 	DayNightThreshold 	)

    {
        setID(ID);
        setName(Name);
        setSiteID(SiteID);
        setSiteName(SiteName);
        setSimID(SimID);
        setFWVersion(FWVersion);
        setUnitType(UnitType);
        setLastContact(LastContact);
        setHearBeat(HearBeat);
        setTotalPower(TotalPower);
        setBatteryChanged(BatteryChanged);
        setLastPower(LastPower);
        setThisMonth(ThisMonth);
        setDataThisMonth(DataThisMonth);
        setDataLastMonth(DataLastMonth);
        setDataAllowance(DataAllowance);
        setLastBatteryChange(LastBatteryChange);
        setBatteryType(BatteryType);
        setNewBattery(NewBattery);
        setTimeLine(TimeLine);
        setPIR_ID(PIR_ID);
        setCamera_ID(Camera_ID);
        setMAC(MAC);
        setOperator(Operator);
        setVoiceTwoWay(VoiceTwoWay);
        setCatchDayNight(CatchDayNight);
        setDayNightThreshold(DayNightThreshold);



    }

}