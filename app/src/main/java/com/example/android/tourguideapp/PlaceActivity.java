package com.example.android.tourguideapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class PlaceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place);

        Place place = (Place) getIntent().getExtras().getSerializable("place");

        TextView nameTextView = findViewById(R.id.name_text_view);
        nameTextView.setText(place.getName());

    }
}
