package com.padc.batch9.assignment5.activity.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;

import com.padc.batch9.assignment5.R;
import com.padc.batch9.assignment5.activity.HouseDetailActivity;
import com.padc.batch9.assignment5.activity.data.vo.HouseVo;
import com.padc.batch9.assignment5.activity.delegate.HouseItemDelegate;
import com.padc.batch9.assignment5.activity.view.viewholder.HouseViewHolder;

public class HouseAdapter extends BaseRecyclerViewAdapter<HouseViewHolder, HouseVo>{
    private String tag = getClass().getSimpleName();
    //Context context;
    HouseItemDelegate delegate;

    public HouseAdapter(HouseItemDelegate delegate) {
        //this.context = context;
        this.delegate = delegate;
    }

    @NonNull
    @Override
    public HouseViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        Log.i(tag, "onCreateVeiwHolder");
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.listitem_house,
                viewGroup, false);
        return new HouseViewHolder(view, delegate);
    }

}
