package com.padc.batch9.assignment5.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.padc.batch9.assignment5.R;
import com.padc.batch9.assignment5.activity.data.vo.model.HouseModelImpl;

public class BaseActivity extends AppCompatActivity {

    protected HouseModelImpl houseModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        houseModel = HouseModelImpl.getObjInstance();
    }

    protected void showIdefiniteSnakBar(String message) {
        final Snackbar snackbar =  Snackbar.make(getWindow().getDecorView(), message,
                Snackbar.LENGTH_INDEFINITE);
        snackbar.setAction(getString(R.string.label_okay), new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                snackbar.dismiss();
            }
        });
    }
}
