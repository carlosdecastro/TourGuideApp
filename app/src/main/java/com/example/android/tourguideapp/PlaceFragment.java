package com.example.android.tourguideapp;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class PlaceFragment extends Fragment implements OnMapReadyCallback {

    List<Place> places = null;
    View rootView = null;

    public PlaceFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        rootView = inflater.inflate(R.layout.fragment_place, container, false);


        // Inflate the layout for this fragment
        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        MapView mapView;

        mapView = view.findViewById(R.id.map);
        mapView.onCreate(savedInstanceState);
        mapView.onResume();
        mapView.getMapAsync(this);

        Bundle args = getArguments();
        places = City.getInstance().getPlacesByCategory(args.getInt("category", 0));

        final RecyclerView placesRecyclerView = rootView.findViewById(R.id.places_recycler_view);
        placesRecyclerView.setHasFixedSize(true);

        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        placesRecyclerView.setLayoutManager(llm);

        PlaceAdapter adapter = new PlaceAdapter(getContext(), places);
        placesRecyclerView.setAdapter(adapter);

        FloatingActionButton floatingButton = view.findViewById(R.id.floatingScrollButton);
        floatingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                placesRecyclerView.smoothScrollToPosition(0);
            }
        });
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {

        for (Place place : places) {

            LatLng location = new LatLng(place.getLatitude(), place.getLongitude());
            googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(location, 15));

            googleMap.addMarker(new MarkerOptions().position(location).title("Marker in: " + place.getName()));
            //mMap.moveCamera(CameraUpdateFactory.newLatLng(location));
            //mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(location, 15));
            //mMap.animateCamera(CameraUpdateFactory.zoomIn());
        }

    }

}
