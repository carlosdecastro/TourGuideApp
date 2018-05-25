package com.example.android.tourguideapp;

import java.io.Serializable;

public class Place implements Serializable {

    private String mName;
    private int mCategory;
    private String mAddress;
    private String mDescription;
    private String mOpeningHours;
    private double mPrice;
    private String mPhone;
    private String mWebPage;
    private int mImageResourceId;
    private double mLongitude;
    private double mLatitude;

    public Place(String name, int category) {
        mName = name;
        mCategory = category;
        City.getInstance().addPlace(this);
    }

    public String getName() {
        return mName;
    }

    public int getCategory() {
        return mCategory;
    }


}
