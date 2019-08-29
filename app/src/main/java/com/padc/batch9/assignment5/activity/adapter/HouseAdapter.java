package com.padc.batch9.assignment5.activity.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.padc.batch9.assignment5.R;
import com.padc.batch9.assignment5.activity.view.viewholder.HouseViewHolder;

public class HouseAdapter extends RecyclerView.Adapter<HouseViewHolder> {
    @NonNull
    @Override
    public HouseViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.listitem_house,
                viewGroup, false);
        return new HouseViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HouseViewHolder houseViewHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return 4;
    }
}
