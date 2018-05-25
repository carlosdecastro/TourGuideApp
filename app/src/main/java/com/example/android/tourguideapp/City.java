package com.example.android.tourguideapp;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class City {

    private static final City INSTANCE = new City("Santiago");

    private String mName;
    private int mPopulation;
    private List<Place> mPlaces = new ArrayList<Place>();


    private City(String name) {
        mName = name;
    }

    protected static City getInstance() {

        return INSTANCE;
    }

    public List<Place> getPlacesByCategory(int category) {

        List<Place> places = new ArrayList<Place>();

        for(Place place : mPlaces)
        {
                if (place.getCategory() == category)
                    places.add(place);

        }

        return places;
    }

    public void addPlace(Place place) {
        mPlaces.add(place);
    }
}
