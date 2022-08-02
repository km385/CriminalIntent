package com.example.criminalintent;

import java.util.Date;
import java.util.UUID;

public class Crime {

    private UUID mId;
    private String mTitle;
    private Date mDate;
    private boolean mSolved;
    private int mRequiresPolice;
    private String mSuspect;
    private String mSuspectNumber;

    public Crime(){
        this(UUID.randomUUID());
    }

    public Crime(UUID id){
        mId = id;
        mDate = new Date();
    }

    public UUID getId() {
        return mId;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public Date getDate() {
        return mDate;
    }

    public void setDate(Date date) {
        mDate = date;
    }

    public boolean isSolved() {
        return mSolved;
    }

    public void setSolved(boolean solved) {
        mSolved = solved;
    }

    public int getRequiresPolice() {
        return mRequiresPolice;
    }

    public void setRequiresPolice(int RequiresPolice) {
        mRequiresPolice = RequiresPolice;
    }

    public String getSuspect() {
        return mSuspect;
    }

    public void setSuspect(String Suspect) {
        mSuspect = Suspect;
    }

    public String getSuspectNumber() {
        return mSuspectNumber;
    }

    public void setSuspectNumber(String SuspectNumber) {
        mSuspectNumber = SuspectNumber;
    }

    public String getPhotoFilename(){
        return "IMG_" + getId().toString() + ".jpg";
    }
}
