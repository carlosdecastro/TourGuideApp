package com.example.android.tourguideapp;

import java.io.Serializable;

public class Place implements Serializable {

    private String mName;
    private int mCategory;
    private String mShortDescription;
    private int mImageResourceId;
    private int mImageResourceFullId;
    private double mLatitude;
    private double mLongitude;


    public Place(String name, String shortDescription, int category, double latitude, double longitude, int imageResourceId, int imageResourceFullId) {
        mName = name;
        mCategory = category;
        mLatitude = latitude;
        mLongitude = longitude;
        mImageResourceId = imageResourceId;
        mShortDescription = shortDescription;
        mImageResourceFullId = imageResourceFullId;
        City.getInstance().addPlace(this);
    }

    public String getName() {
        return mName;
    }

    public int getCategory() {
        return mCategory;
    }

    public double getLatitude() {
        return mLatitude;
    }

    public double getLongitude() {
        return mLongitude;
    }

    public int getImageResourceId() {
        return mImageResourceId;
    }

    public String getShortDescription() {
        return mShortDescription;
    }

    public int getImageResourceFullId() {
        return mImageResourceFullId;
    }

}
