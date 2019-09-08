package com.padc.batch9.assignment5.activity.view.viewholder;

import android.support.annotation.NonNull;
import android.support.design.chip.Chip;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatTextView;
import android.view.View;
import com.bumptech.glide.Glide;
import com.padc.batch9.assignment5.R;
import com.padc.batch9.assignment5.activity.data.vo.HouseVo;
import com.padc.batch9.assignment5.activity.delegate.HouseItemDelegate;

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
    @BindView(R.id.fab_get_direction)
    FloatingActionButton fabGetDirection;
    HouseItemDelegate delegate;


    public HouseViewHolder(@NonNull View itemView, final HouseItemDelegate delegate) {
        super(itemView);
        this.delegate = delegate;
        ButterKnife.bind(this, itemView);
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                delegate.onTapHouseItemEvent(mData.getId());
            }
        });
        fabGetDirection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                delegate.onFabGetDirectionClickEvent(mData.getId());
            }
        });
    }

    @Override
    public void bindData(HouseVo data) {
        mData = data;
        tvPrice.setText(mData.getPrice()+"");
        tvHouseName.setText(mData.getName());
        tvSquareFt.setText(mData.getSquareFt()+"");
        Glide.with(itemView).load(mData.getHouseImageUrl()).into(imgvHouse);
    }

}
