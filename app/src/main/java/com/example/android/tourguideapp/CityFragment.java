package com.example.android.tourguideapp;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextClock;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class CityFragment extends Fragment {


    public CityFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_city, container, false);

        TextView cityNameTextView = rootView.findViewById(R.id.city_name_text_view);
        cityNameTextView.setText(City.getName());

        TextClock timeTextClock = rootView.findViewById(R.id.city_time_text_clock);
        timeTextClock.setTimeZone("GMT+02:00");

        ImageView faceBookImageView = rootView.findViewById(R.id.city_facebook_image_view);
        faceBookImageView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String facebookId = getString(R.string.city_facebook);
                startActivity(new Intent(Intent.ACTION_DEFAULT, Uri.parse(facebookId)));
            }

        });

        ImageView instagramImageView = rootView.findViewById(R.id.city_instagram_image_view);
        instagramImageView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String instagramId = getString(R.string.city_twitter);
                startActivity(new Intent(Intent.ACTION_DEFAULT, Uri.parse(instagramId)));
            }

        });

        ImageView twitterImageView = rootView.findViewById(R.id.city_twitter_image_view);
        twitterImageView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String instagramId = getString(R.string.city_instagram);
                startActivity(new Intent(Intent.ACTION_DEFAULT, Uri.parse(instagramId)));
            }

        });


        return rootView;
    }

}
