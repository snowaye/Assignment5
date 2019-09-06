package com.padc.batch9.assignment5.activity.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.padc.batch9.assignment5.R;
import com.padc.batch9.assignment5.activity.adapter.HouseAdapter;
import com.padc.batch9.assignment5.activity.data.vo.HouseVo;
import com.padc.batch9.assignment5.activity.data.vo.model.HouseModel;
import com.padc.batch9.assignment5.activity.data.vo.model.HouseModelImpl;
import com.padc.batch9.assignment5.activity.delegate.HouseDataDelegate;

import java.util.List;

public class TopCollectionFragment extends BaseFragment {

    private String tag = getClass().getSimpleName();
    RecyclerView recyclerView;
    LinearLayoutManager manager;
    HouseDataDelegate delegate;
    List<HouseVo> list;
    HouseAdapter houseAdapter;

    public TopCollectionFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.from(getContext()).inflate(R.layout.fragment_top_collection, container,
                false);

        recyclerView = view.findViewById(R.id.recyclerview);
        manager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL,
                false);
        recyclerView.setLayoutManager(manager);
        houseAdapter = new HouseAdapter(getContext());
        recyclerView.setAdapter(houseAdapter);
        houseAdapter.setViewData(list);

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            delegate = (HouseDataDelegate) context;
            list = delegate.sendHouseDataToFragments();
            Log.i(tag, "list==="+list.size());
        }
        catch (ClassCastException e) {
            e.printStackTrace();
        }

    }
}
