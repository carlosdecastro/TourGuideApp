package com.example.android.tourguideapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class PlaceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_city);
        setTitle("Place");

        Place place = (Place) getIntent().getExtras().getSerializable("place");

        TextView nameTextView = findViewById(R.id.city_name_text_view);
        nameTextView.setText(place.getName());
        TextView cityDescriptionTextView = findViewById(R.id.city_description_text_view);
        cityDescriptionTextView.setText(place.getShortDescription());

        ImageView placeImageView = findViewById(R.id.imageView);
        placeImageView.setImageResource(place.getImageResourceFullId());

        TextView categoryTextView = findViewById(R.id.category_text_view);

        LinearLayout socialLayout = findViewById(R.id.city_linear_layout);
        socialLayout.setVisibility(View.VISIBLE);

        int category = place.getCategory();

        if (category == 1) {
            categoryTextView.setText(R.string.categoryOne);
        } else if (category == 2) {
            categoryTextView.setText(R.string.category_two);
        } else if (category == 3) {
            categoryTextView.setText(R.string.category_three);
        } else {
            categoryTextView.setText(R.string.category_five);
        }

        ImageView faceBookImageView = findViewById(R.id.city_facebook_image_view);
        faceBookImageView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String facebookId = getString(R.string.city_facebook);
                startActivity(new Intent(Intent.ACTION_DEFAULT, Uri.parse(facebookId)));
            }

        });

        ImageView instagramImageView = findViewById(R.id.city_instagram_image_view);
        instagramImageView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String instagramId = getString(R.string.city_twitter);
                startActivity(new Intent(Intent.ACTION_DEFAULT, Uri.parse(instagramId)));
            }

        });

        ImageView twitterImageView = findViewById(R.id.city_twitter_image_view);
        twitterImageView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String instagramId = getString(R.string.city_instagram);
                startActivity(new Intent(Intent.ACTION_DEFAULT, Uri.parse(instagramId)));
            }

        });

        TextView countryTextView = findViewById(R.id.country_text_view);
        countryTextView.setVisibility(View.INVISIBLE);

    }
}
