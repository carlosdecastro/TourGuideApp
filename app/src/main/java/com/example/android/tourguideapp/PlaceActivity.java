package com.example.android.tourguideapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class PlaceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_city);

        Place place = (Place) getIntent().getExtras().getSerializable("place");

        TextView nameTextView = findViewById(R.id.city_name_text_view);
        nameTextView.setText(place.getName());
        TextView cityDescriptionTextView = findViewById(R.id.city_description_text_view);
        //cityDescriptionTextView.setText(place.getShortDescription());

        ImageView placeImageView = findViewById(R.id.imageView);
        placeImageView.setImageResource(place.getImageResourceFullId());

        TextView categoryTextView = findViewById(R.id.category_text_view);

        int category = place.getCategory();

        if (category == 1) {
            categoryTextView.setText("See");
        } else if (category == 2) {
            categoryTextView.setText("Restaurant");
        } else if (category == 3) {
            categoryTextView.setText("Thing to do");
        } else {
            categoryTextView.setText("Hotel");
        }

        TextView countryTextView = findViewById(R.id.country_text_view);
        countryTextView.setVisibility(View.INVISIBLE);

    }
}
