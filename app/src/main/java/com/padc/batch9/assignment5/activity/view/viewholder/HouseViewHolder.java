package com.padc.batch9.assignment5.activity.view.viewholder;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.View;

import com.padc.batch9.assignment5.activity.data.vo.HouseVo;

import java.util.List;

public class HouseViewHolder extends BaseViewHolder<List<HouseVo>> {

    public HouseViewHolder(@NonNull View itemView) {
        super(itemView);

    }

    @Override
    public void bindData(List<HouseVo> mData) {
        Log.i("HouseViewHolder", "mData="+mData.get(0).getName());
    }


}
