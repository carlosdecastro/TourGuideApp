package com.example.android.tourguideapp;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class PlaceFragment extends Fragment {

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

        Bundle args = getArguments();
        places = City.getInstance().getPlacesByCategory(args.getInt("category", 0));

        RecyclerView placesRecyclerView = (RecyclerView) rootView.findViewById(R.id.places_recycler_view);
        placesRecyclerView.setHasFixedSize(true);

        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        placesRecyclerView.setLayoutManager(llm);

        PlaceAdapter adapter = new PlaceAdapter(getContext(), places);
        placesRecyclerView.setAdapter(adapter);
    }
}
