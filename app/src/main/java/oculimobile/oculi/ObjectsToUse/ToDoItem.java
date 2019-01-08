package oculimobile.oculi.ObjectsToUse;


/**
 * Represents an item in a ToDo list
 */

public class ToDoItem {

    /**
     * EventID
     */

    @com.google.gson.annotations.SerializedName("evtYear")
    private int mEvtYear;
    @com.google.gson.annotations.SerializedName("evtMonth")
    private int mEvtMonth;
    @com.google.gson.annotations.SerializedName("evtDay")
    private int mEvtDay;
    @com.google.gson.annotations.SerializedName("evtMinute")
    private int mEvtMinute;
    @com.google.gson.annotations.SerializedName("updateDate")
    private String mUpdateDate;
    //username is used for SITENAME
    @com.google.gson.annotations.SerializedName("username")
    private String musername;
    @com.google.gson.annotations.SerializedName("eventID")
    private String meventID;
    @com.google.gson.annotations.SerializedName("cameraName")
    private String mCameraName;
    /**
     * Item text
     */
    @com.google.gson.annotations.SerializedName("text")
    private String mText;
    /**
     * Item Id
     */
    @com.google.gson.annotations.SerializedName("id")
    private String mId;
    /**
     * Indicates if the item is completed
     */
    @com.google.gson.annotations.SerializedName("complete")
    private boolean mComplete;

    @com.google.gson.annotations.SerializedName("usertag")
    private String mTag;
    /**
     * ToDoItem constructor
     */


//    @com.google.gson.annotations.SerializedName("_createdAt")
//    private DateTimeOffset mCreatedAt;
//    public DateTimeOffset CreatedgetUpdatedAt()
//    {
//        return mCreatedAt;
//    }
//    public final void CreatedsetUpdatedAt(DateTimeOffset createdAt)
//    {
//        mCreatedAt = createdAt;
//    }
//
//    @com.google.gson.annotations.SerializedName("_updatedAt")
//    private DateTimeOffset mUpdatedAt;
//    public DateTimeOffset UpdatedgetUpdatedAt() { return mUpdatedAt; }
//    public final void  UpdatedsetUpdatedAt(DateTimeOffset updatedAt) { mUpdatedAt = updatedAt; }

    public ToDoItem() {

    }

    @Override
    public String toString() {
        return getText();
    }

    /**
     * Initializes a new ToDoItem
     *
     * @param text
     *            The item text
     * @param id
     *            The item id
     *
     */

    public ToDoItem(String text, String id,String CameraName, String UpdateDate,String Tag,int Year,int Month,int Day,int Minute) {
        this.setText(text);
        this.setId(id);
        this.setCameraName(CameraName);
        this.setUpdateDate(UpdateDate);
        this.setTag(Tag);
        this.setEvtYear(Year);
        this.setEvtDay(Day);
        this.setEvtMonth(Month);
        this.setEvtMinute(Minute);
//        this.UpdatedsetUpdatedAt(updated);
//        this.CreatedsetUpdatedAt(created);
    }

    public String getTag() {
        return mTag;
    }


    /**
     * Sets the item text
     *
     * @param text
     *            text to set
     */
    public final void setTag(String text) {
        mTag = text;
    }

    /**
     * Returns the item text
     */
    public String getText() {
        return mText;
    }


    /**
     * Sets the item text
     *
     * @param text
     *            text to set
     */
    public final void setText(String text) {
        mText = text;
    }

    /**
     * Returns the item id
     */
    public String getId() {
        return mId;
    }

    /**
     * Sets the item id
     *
     * @param id
     *            id to set
     */

    public final void setId(String id) {
        mId = id;
    }

// new

    public String getUsername() {
        return musername;
    }
    public final void setUsername(String username) {
        musername = username;
    }

    public String getEventID() {
        return meventID;
    }
    public final void setEventID(String eventID) {
        meventID = eventID;
    }
    /**
     * Indicates if the item is marked as completed
     */
    public boolean isComplete() {
        return mComplete;
    }

    /**
     * Marks the item as completed or incompleted
     */
    public void setComplete(boolean complete) {
        mComplete = complete;
    }


    //GET/SET
    public String getCameraName()
    {
        return mCameraName;
    }
    public final void setCameraName(String cameraname)
    {
        mCameraName = cameraname;
    }

    public String getUpdateDate()
    {
        return mUpdateDate;
    }
    public final void setUpdateDate(String emUpdateDate)
    {
        mUpdateDate = emUpdateDate;
    }


    //Data


    public int getEvDYear()
    {
        return mEvtYear;
    }
    public final void setEvtYear(int emUpdateDate)
    {
        mEvtYear = emUpdateDate;
    }
    public int getEvtMonth()
    {
        return mEvtMonth;
    }
    public final void setEvtMonth(int emUpdateDate)
    {
        mEvtMonth = emUpdateDate;
    }
    public int getEvtDay()
    {
        return mEvtDay;
    }
    public final void setEvtDay(int emUpdateDate)
    {
        mEvtDay = emUpdateDate;
    }
    public int getEvtMinute()
    {
        return mEvtMinute;
    }
    public final void setEvtMinute(int emUpdateDate)
    {
        mEvtMinute = emUpdateDate;
    }

    public ToDoItem(String text, String id) {
        this.setText(text);
        this.setId(id);
    }




    @Override
    public boolean equals(Object o) {
        return o instanceof ToDoItem && ((ToDoItem) o).mId == mId;
    }
}


