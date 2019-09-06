package com.padc.batch9.assignment5.activity.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.padc.batch9.assignment5.activity.view.viewholder.BaseViewHolder;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseRecyclerViewAdapter<T extends BaseViewHolder<w>, w> extends RecyclerView.Adapter<T> {
    private String tag = getClass().getSimpleName();
    List<w> mData;

    public BaseRecyclerViewAdapter() {
        mData = new ArrayList<>();
    }

    @Override
    public void onBindViewHolder(@NonNull T holder, int i) {
        holder.bindData(mData.get(i));
    }

    @Override
    public int getItemCount() {
        Log.i(tag, "getJItemCount");
        if (mData!=null) {
            Log.i(tag, "mDAta="+mData.size());
            return mData.size();
        }
        else return 0;
    }

    public void setViewData(List<w> data) {
        mData = data;
        notifyDataSetChanged();
    }
}
