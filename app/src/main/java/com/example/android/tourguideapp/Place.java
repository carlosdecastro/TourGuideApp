package com.example.android.tourguideapp;

import java.io.Serializable;

public class Place implements Serializable {

    private String mName;
    private int mCategory;
    private String mAddress;
    private String mShortDescription;
    private String mOpeningHours;
    private double mPrice;
    private String mPhone;
    private String mWebPage;
    private int mImageResourceId;
    private double mLatitude;
    private double mLongitude;


    public Place(String name, String shortDescription, int category, double latitude, double longitude, int imageResourceId) {
        mName = name;
        mCategory = category;
        mLatitude = latitude;
        mLongitude = longitude;
        mImageResourceId = imageResourceId;
        mShortDescription = shortDescription;
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
}
