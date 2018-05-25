package com.example.android.tourguideapp;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //Dummy Data
        Place placeOne = new Place("Catedral", 1);
        Place placeTwo = new Place("Embora", 1);
        Place placeThree = new Place("Parlamento", 2);
        Place placeFour = new Place("Pontepedriña", 3);
        Place placeFive = new Place("CGAC", 4);
        Place placeSix = new Place("Moon", 2);




        City.getInstance();

        ViewPager cityCategoriesPager = findViewById(R.id.city_categories_pager);

        CategoryAdapter categoryAdapter = new CategoryAdapter(getSupportFragmentManager());

        cityCategoriesPager.setAdapter(categoryAdapter);
    }
}
