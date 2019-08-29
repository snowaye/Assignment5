package com.padc.batch9.assignment5.activity.view.viewholder;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.padc.batch9.assignment5.activity.data.vo.HouseVo;

public class HouseViewHolder extends BaseViewHolder<HouseVo> {

    public HouseViewHolder(@NonNull View itemView) {
        super(itemView);
    }

    @Override
    public void bindData(HouseVo mData) {
        Log.i("HouseViewHolder", "mData="+mData.getName());
    }
}
