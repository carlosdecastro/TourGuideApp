package com.example.android.tourguideapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class CategoryAdapter extends FragmentPagerAdapter {

    private String tabTitles[] = new String[]{"Numbers", "Family", "Colors", "Phrases"};

    public CategoryAdapter(FragmentManager fm) {

        super(fm);
    }

    @Override
    public Fragment getItem(int position) {

        Bundle args = new Bundle();
        PlaceFragment placeFragment = new PlaceFragment();

        switch (position) {
            case 0:

                return new CityFragment();

            case 1:

                args.putInt("category", 1);
                placeFragment.setArguments(args);

                return placeFragment;

            case 2:

                args.putInt("category", 2);
                placeFragment.setArguments(args);

                return placeFragment;

            case 3:
                args.putInt("category", 3);
                placeFragment.setArguments(args);

                return placeFragment;

        }
        return null;
    }

    @Override
    public int getCount() {
        return 4;
    }

   /* @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitles[position];
    }*/
}
