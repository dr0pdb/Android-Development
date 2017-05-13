package com.example.android.miwok;

import android.media.MediaPlayer;

public class Word {

    private String defaulttranslation;
    private String mioktranslation;
    private int imageresourceid=NO_IMAGE_INSERTED;
    private int soundResourceId;


    public static final int NO_IMAGE_INSERTED=-1;

    public Word(String defaulttranslation, String mioktranslation, int soundResourceId){
        this.defaulttranslation= defaulttranslation;
        this.mioktranslation = mioktranslation;
        this.soundResourceId=soundResourceId;
    }

    public Word(String defaulttranslation , String mioktranslation , int imageresourceid,int soundResourceId){
        this.defaulttranslation=defaulttranslation;
        this.mioktranslation= mioktranslation;
        this.imageresourceid= imageresourceid;
        this.soundResourceId=soundResourceId;
    }

    public String getDefaulttranslation() {
        return defaulttranslation;
    }

    public String getMioktranslation() {
        return mioktranslation;
    }

    public int getImageresourceid() {return imageresourceid;}

    public boolean hasImage(){
        return imageresourceid !=NO_IMAGE_INSERTED;
    }

    public int getSoundResourceId() {
        return soundResourceId;
    }
}
