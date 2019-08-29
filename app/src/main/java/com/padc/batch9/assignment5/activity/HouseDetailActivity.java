package com.padc.batch9.assignment5.activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.padc.batch9.assignment5.R;
import com.padc.batch9.assignment5.activity.util.Utils;

public class HouseDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_house_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Utils.setStatusBarColor(this, R.color.statusBarColor);

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
