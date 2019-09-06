package com.padc.batch9.assignment5.activity.data.vo.model;

import com.padc.batch9.assignment5.activity.data.vo.HouseVo;

import java.util.List;

public interface HouseModel {

    void getHouse(GetHouseModelFromDataLayer delegate);

    HouseVo findHouseById(int id);

    interface GetHouseModelFromDataLayer {
        void onSuccess(List<HouseVo> houses);
        void onFailure(String errorMessage);

    }
}
