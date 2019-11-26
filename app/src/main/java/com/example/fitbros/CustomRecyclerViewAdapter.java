package com.example.fitbros;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fitbros.JavaBeans.Workout;

import java.util.ArrayList;

public class CustomRecyclerViewAdapter extends RecyclerView.Adapter {

    private ArrayList<Workout> workouts;

    public CustomRecyclerViewAdapter(ArrayList<Workout> workouts) {
        this.workouts = workouts;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        //Make the view that we want each list item to look like
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycleview_items, null);
        CustomViewHolder viewHolder = new CustomViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Workout workout = workouts.get(position);

        ((CustomViewHolder)holder).name.setText(workout.getName());
        ((CustomViewHolder)holder).image.setImageResource(workout.getImage());
        ((CustomViewHolder)holder).description.setText(workout.getDescription());
        ((CustomViewHolder)holder).amountReps.setText(workout.getAmountReps());
    }

    @Override
    public int getItemCount() {
        if(workouts != null) {
            return workouts.size();
        }
        return 0;
    }

    class CustomViewHolder extends RecyclerView.ViewHolder {

        protected TextView name;
        protected ImageView image;
        protected TextView description;
        protected TextView amountReps;

        public CustomViewHolder(View view) {
            super(view);
            this.name = view.findViewById(R.id.workoutName);
            this.image = view.findViewById(R.id.workoutImage);
            this.description = view.findViewById(R.id.workoutDesc);
            this.amountReps = view.findViewById(R.id.workoutReps);
        }
    }
}
