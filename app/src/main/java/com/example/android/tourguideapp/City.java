package com.example.android.tourguideapp;

import java.util.ArrayList;
import java.util.List;

public class City {

    private static final City INSTANCE = new City("Santiago de Compostela");

    private static String mName;
    private static String mTimeZone;
    private int mPopulation;
    private List<Place> mPlaces = new ArrayList<Place>();
    private static boolean isInitialized = false;


    private City(String name) {
        mName = name;
    }

    protected static City getInstance() {

        return INSTANCE;
    }

    public static boolean isInitialized() {
        return isInitialized;
    }

    public void addPlace(Place place) {
        mPlaces.add(place);
    }

    public static void setInitialized(boolean isInitialized) {
        City.isInitialized = isInitialized;
    }

    public static String getName() {
        return mName;
    }

    public static String getTimeZone() {
        return mTimeZone;
    }

    public List<Place> getPlacesByCategory(int category) {

        List<Place> places = new ArrayList<Place>();

        for (Place place : mPlaces) {
            if (place.getCategory() == category)
                places.add(place);

        }

        return places;
    }
}
