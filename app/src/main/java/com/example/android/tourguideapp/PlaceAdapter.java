package com.example.android.tourguideapp;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;


public class PlaceAdapter extends RecyclerView.Adapter<PlaceAdapter.PlaceViewHolder> {


    public static class PlaceViewHolder extends RecyclerView.ViewHolder {

        CardView mCardView;
        TextView mName;
        TextView mCategory;
        //ImageView personPhoto;

        PlaceViewHolder(View itemView) {
            super(itemView);
            mCardView = (CardView)itemView.findViewById(R.id.place_card_view);
            mName = (TextView)itemView.findViewById(R.id.person_name);
            mCategory = (TextView)itemView.findViewById(R.id.person_age);
        }
    }

    private List<Place> mPlaces;
    private Context mContext;

    public PlaceAdapter(Context context, List<Place> places){
        mContext = context;
        mPlaces = places;
    }

    @Override
    public void onBindViewHolder(@NonNull PlaceViewHolder holder, final int position) {

        holder.mName.setText(mPlaces.get(position).getName());
        //holder.mName.setText(mPlaces.get(position).getCategory());
        holder.mCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Place currentPlace = (Place) mPlaces.get(position);

                Intent playIntent = new Intent(mContext,PlaceActivity.class);
                playIntent.putExtra("place", currentPlace);
                mContext.startActivity(playIntent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return mPlaces.size();
    }

    @NonNull
    @Override
    public PlaceViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.place_item, parent, false);
        PlaceViewHolder placeViewHolder = new PlaceViewHolder(v);
        return placeViewHolder;
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }
}