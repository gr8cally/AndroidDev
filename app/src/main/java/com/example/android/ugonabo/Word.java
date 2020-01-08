package com.example.android.ugonabo;

/**
 * Created by user on 6/10/2019.
 */
/*Represents a vocabulary word that the user wants to learn
it contains an English Translation and an Igbo translation*/

public class Word {
    private String englishTranslation;
    private String igboTranslation;
    private int imageResourceId = NO_IMAGE_PROVIDED;
    private int soundResourceId;

    private static final int NO_IMAGE_PROVIDED = -1;

    public Word(String english, String igbo, int soundId){
        this.englishTranslation = english;
        this.igboTranslation = igbo;
        soundResourceId = soundId;
    }

    public Word(String english, String igbo, int imageId, int soundId){
        this.englishTranslation = english;
        this.igboTranslation = igbo;
        this.imageResourceId = imageId;
        soundResourceId = soundId;
    }

    public String getEnglishTranslation(){

        return englishTranslation;
    }

    public String getIgboTranslation(){
        return igboTranslation;
    }
    public int getImageResourceId(){
        return imageResourceId;
    }
    public int getSoundResourceId() { return soundResourceId; }

//    Returns whether or not there is an image for this word
    public boolean hasImage(){
        return imageResourceId != NO_IMAGE_PROVIDED;
    }
}
