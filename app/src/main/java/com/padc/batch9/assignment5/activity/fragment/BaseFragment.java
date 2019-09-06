package com.padc.batch9.assignment5.activity.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import com.padc.batch9.assignment5.activity.data.vo.model.HouseModelImpl;

public class BaseFragment extends Fragment {

    HouseModelImpl houseModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        houseModel = HouseModelImpl.getObjInstance();
    }
}
