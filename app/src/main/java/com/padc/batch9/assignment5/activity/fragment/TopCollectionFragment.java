package com.padc.batch9.assignment5.activity.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.padc.batch9.assignment5.R;
import com.padc.batch9.assignment5.activity.adapter.HouseAdapter;

public class TopCollectionFragment extends Fragment {

    public TopCollectionFragment() {
    }

    RecyclerView recyclerView;
    LinearLayoutManager manager;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.from(getContext()).inflate(R.layout.fragment_top_collection, container,
                false);

        return view;
    }
}
