package com.example.android.miwok;

public class Word {

    private String defaulttranslation;
    private String mioktranslation;

    public Word(String defaulttranslation, String mioktranslation){
        this.defaulttranslation= defaulttranslation;
        this.mioktranslation = mioktranslation;
    }

    public String getDefaulttranslation() {
        return defaulttranslation;
    }

    public String getMioktranslation() {
        return mioktranslation;
    }
}
