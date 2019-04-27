package com.thiagomatheusms.materialdesign.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.thiagomatheusms.materialdesign.Model.Restaurant;
import com.thiagomatheusms.materialdesign.R;

import java.util.ArrayList;
import java.util.List;

public class AdapterHomeActivity extends RecyclerView.Adapter<AdapterHomeActivity.AdapterHomeActivityViewHolder> {

    private List<Restaurant> mRestaurants;

    public AdapterHomeActivity() {

        Restaurant restaurant;
        mRestaurants = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            restaurant = new Restaurant();
            restaurant.setName("Restaurant " + i);
            restaurant.setDescription("This is a description.");
            restaurant.setRate(i * 2);
            mRestaurants.add(restaurant);
        }
    }

    @NonNull
    @Override
    public AdapterHomeActivityViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        Context context = viewGroup.getContext();
        int idLayoutItemActivityHome = R.layout.item_activity_home;
        LayoutInflater inflater = LayoutInflater.from(context);

        View view = inflater.inflate(idLayoutItemActivityHome, viewGroup, false);
        AdapterHomeActivityViewHolder adapterHomeActivityViewHolder = new AdapterHomeActivityViewHolder(view);

        return adapterHomeActivityViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterHomeActivityViewHolder adapterHomeActivityViewHolder, int i) {
        Restaurant restaurant = mRestaurants.get(i);

        Picasso.get().
                load("https://images.unsplash.com/photo-1551858985-777ee87ad343?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=334&q=80")
                .into(adapterHomeActivityViewHolder.mRestaurantImage);

        adapterHomeActivityViewHolder.mRestaurantName.setText(restaurant.getName());
        adapterHomeActivityViewHolder.mRestaurantRatingBar.setRating(setRestaurantRating(restaurant.getRate()));
        adapterHomeActivityViewHolder.mRestaurantRate.setText(String.valueOf(restaurant.getRate()));
        adapterHomeActivityViewHolder.mRestaurantDescription.setText(restaurant.getDescription());

    }


    @Override
    public int getItemCount() {
        if (mRestaurants == null) {
            return 0;
        }
        return mRestaurants.size();
    }

    public class AdapterHomeActivityViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public ImageView mRestaurantImage;
        public TextView mRestaurantName, mRestaurantRate, mRestaurantDescription;
        public RatingBar mRestaurantRatingBar;

        public AdapterHomeActivityViewHolder(@NonNull View itemView) {
            super(itemView);

            this.mRestaurantImage = itemView.findViewById(R.id.img_banner_card);
            this.mRestaurantName = itemView.findViewById(R.id.tv_restaurantName);
            this.mRestaurantRatingBar = itemView.findViewById(R.id.ratingBar_restaurant);
            this.mRestaurantRate = itemView.findViewById(R.id.tv_restaurantRate);
            this.mRestaurantDescription = itemView.findViewById(R.id.tv_restaurantDescription);

        }

        @Override
        public void onClick(View v) {

        }
    }

    public float setRestaurantRating(float restaurantRate) {
        float average = ((restaurantRate * 5) / 10);
        return average;
    }
}
