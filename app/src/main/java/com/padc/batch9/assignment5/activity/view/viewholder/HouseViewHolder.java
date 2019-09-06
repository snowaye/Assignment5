package com.padc.batch9.assignment5.activity.view.viewholder;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.chip.Chip;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatTextView;
import android.util.Log;
import android.view.View;

import com.bumptech.glide.Glide;
import com.padc.batch9.assignment5.R;
import com.padc.batch9.assignment5.activity.data.vo.HouseVo;
import butterknife.BindView;
import butterknife.ButterKnife;

public class HouseViewHolder extends BaseViewHolder<HouseVo> {

    @BindView(R.id.imgv_house)
    AppCompatImageView imgvHouse;
    @BindView(R.id.chip_price)
    Chip tvPrice;
    @BindView(R.id.tv_house_name)
    AppCompatTextView tvHouseName;
    @BindView(R.id.tv_squareft)
    AppCompatTextView tvSquareFt;


    public HouseViewHolder(@NonNull View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    @Override
    public void bindData(HouseVo mData) {
        tvPrice.setText(mData.getPrice()+"");
        tvHouseName.setText(mData.getName());
        tvSquareFt.setText(mData.getSquareFt()+"");
        Glide.with(itemView).load(mData.getHouseImageUrl()).into(imgvHouse);
    }

}
