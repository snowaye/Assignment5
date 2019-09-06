package com.padc.batch9.assignment5.activity.data.vo.model;

import com.padc.batch9.assignment5.activity.data.vo.HouseVo;
import com.padc.batch9.assignment5.activity.network.dataagent.HouseDataAgent;
import com.padc.batch9.assignment5.activity.util.HouseConstant;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HouseModelImpl extends BaseModel implements HouseModel {

    private static HouseModelImpl objInstance;
    private Map<Integer, HouseVo> houseDataReposistory;
    //private List<HouseVo> houseDataReposistory;

    private HouseModelImpl() {
        houseDataReposistory = new HashMap<>();
        //houseDataReposistory = new ArrayList<>();
    }

    public static HouseModelImpl getObjInstance() {
        if (objInstance==null)
            objInstance = new HouseModelImpl();
        return objInstance;
    }
    @Override
    public void getHouse(final GetHouseModelFromDataLayer delegate) {
        mDataAgent.getHouse(new HouseDataAgent.GetHouseFromNetworkDelegate() {
            @Override
            public void onSuccess(List<HouseVo> houses) {
                for (HouseVo house:houses) {
                    houseDataReposistory.put(house.getId(), house);
                }
                delegate.onSuccess(houses);
            }

            @Override
            public void onFailure(String errorMessage) {
                delegate.onFailure(HouseConstant.EM_NULL_RESPONSE);
            }
        });
    }

    @Override
    public HouseVo findHouseById(int id) {
        HouseVo houseVo = null;
        for (Integer i:houseDataReposistory.keySet()) {
            if (i==id)
                houseVo = houseDataReposistory.get(id);
        }
        return houseVo;
    }
}
