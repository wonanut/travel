package com.example.travel.bean;

public class AnnouncementBean {
    private int mesgID;
    private String mesgTitle;
    private String mesgDesc;
    private String mesgAuthor;
    private String mesgDate;

    public int getMesgID() {
        return mesgID;
    }

    public void setMesgID(int mesgID) {
        this.mesgID = mesgID;
    }

    public String getMesgTitle() {
        return mesgTitle;
    }

    public void setMesgTitle(String mesgTitle) {
        this.mesgTitle = mesgTitle;
    }

    public String getMesgDesc() {
        return mesgDesc;
    }

    public void setMesgDesc(String mesgDesc) {
        this.mesgDesc = mesgDesc;
    }

    public String getMesgAuthor() {
        return mesgAuthor;
    }

    public void setMesgAuthor(String mesgAuthor) {
        this.mesgAuthor = mesgAuthor;
    }

    public String getMesgDate() {
        return mesgDate;
    }

    public void setMesgDate(String mesgData) {
        this.mesgDate = mesgData;
    }

    public String getMesgPicture() {
        return mesgPicture;
    }

    public void setMesgPicture(String mesgPicture) {
        this.mesgPicture = mesgPicture;
    }

    private String mesgPicture;

}
