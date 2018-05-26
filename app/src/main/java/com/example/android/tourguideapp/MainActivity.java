package com.example.android.tourguideapp;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private int[] icImageId = {
            R.drawable.common_google_signin_btn_icon_dark,
            R.drawable.common_google_signin_btn_icon_light_normal,
            R.drawable.common_google_signin_btn_text_light_focused,
            R.drawable.common_google_signin_btn_icon_dark_normal};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //Dummy Data
        Place placeOne = new Place("Catedral", 1, 42.880556, -8.543889);
        //Place placeTwo = new Place("Santo Domingo de Bonaval", 1, 42.9,-8.5);
        //Place placeThree = new Place("Parlamento", 2, 44, -9);
        //Place placeFour = new Place("Pontepedriña", 3,43,-3.3);
       /* Place placeFive = new Place("CGAC", 4);
        Place placeSix = new Place("Moon", 2);*/




        City.getInstance();

        ViewPager cityCategoriesPager = findViewById(R.id.city_categories_pager);

        CategoryAdapter categoryAdapter = new CategoryAdapter(getSupportFragmentManager());

        cityCategoriesPager.setAdapter(categoryAdapter);

        // Give the TabLayout the ViewPager
        TabLayout tabLayout = findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(cityCategoriesPager);


        for (int i = 0; i < icImageId.length; i++) {
            tabLayout.getTabAt(i).setIcon(icImageId[i]);
        }
    }
}
