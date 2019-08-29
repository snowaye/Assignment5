package com.padc.batch9.assignment5.activity.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import com.padc.batch9.assignment5.activity.view.viewholder.BaseViewHolder;

import java.util.List;

public abstract class BaseRecyclerViewAdapter<T extends BaseViewHolder<w>, w> extends RecyclerView.Adapter<T> {

    List<w> mData;

    @Override
    public void onBindViewHolder(@NonNull T holder, int i) {
        holder.bindData(mData.get(i));
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }
}
