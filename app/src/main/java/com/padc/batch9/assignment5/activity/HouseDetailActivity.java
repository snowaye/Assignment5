package com.padc.batch9.assignment5.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.chip.Chip;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.bumptech.glide.Glide;
import com.padc.batch9.assignment5.R;
import com.padc.batch9.assignment5.activity.data.vo.HouseVo;
import com.padc.batch9.assignment5.activity.delegate.HouseItemDelegate;
import com.padc.batch9.assignment5.activity.util.Utils;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HouseDetailActivity extends BaseActivity {

    public static final String IE_HOUSE_ID = "id";
    int houseDetailId;
    HouseVo houseVo;
    @BindView(R.id.imgv_house)
    AppCompatImageView imgvHouse;
    @BindView(R.id.tv_price)
    AppCompatTextView tvPrice;
    @BindView(R.id.tv_name)
    AppCompatTextView tvHouseName;
    @BindView(R.id.tv_squareft)
    AppCompatTextView tvSquareFt;
    @BindView(R.id.tv_description)
    AppCompatTextView tvDescrption;
    @BindView(R.id.tv_address)
    AppCompatTextView tvAddress;
    @BindView(R.id.imgv_back)
    AppCompatImageView imgvBack;

    public static Intent newIntent(Context context, int id) {
        Intent intent = new Intent(context, HouseDetailActivity.class);
        intent.putExtra(IE_HOUSE_ID, id);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_house_detail);
        ButterKnife.bind(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Utils.setStatusBarColor(this, R.color.statusBarColor);
        houseDetailId = getIntent().getIntExtra(IE_HOUSE_ID, -1);
        houseVo = houseModel.findHouseById(houseDetailId);

        if (houseVo !=null) {
            tvPrice.setText(houseVo.getPrice()+"");
            tvHouseName.setText(houseVo.getName());
            tvSquareFt.setText(houseVo.getSquareFt()+"");
            Glide.with(this).load(houseVo.getHouseImageUrl()).into(imgvHouse);
            tvAddress.setText(houseVo.getAddress());
            tvDescrption.setText(houseVo.getDescription());
        }

        imgvBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

       /*
       if (Build.VERSION.SDK_INT >= 11) {
     yourTextView.setLayerType(View.LAYER_TYPE_SOFTWARE, null);
}
float radius = yourTextView.getTextSize() / 3;
BlurMaskFilter filter = new BlurMaskFilter(radius, BlurMaskFilter.Blur.NORMAL);
yourTextView.getPaint().setMaskFilter(filter);
        */
    }
}
