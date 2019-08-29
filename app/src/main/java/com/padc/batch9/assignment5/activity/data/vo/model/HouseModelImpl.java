package com.padc.batch9.assignment5.activity.data.vo.model;

import com.padc.batch9.assignment5.activity.data.vo.HouseVo;
import com.padc.batch9.assignment5.activity.network.dataagent.HouseDataAgent;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HouseModelImpl extends BaseModel implements HouseModel {

    private static HouseModelImpl objInstance;
    private Map<Integer, HouseVo> eventtDataRepository;

    private HouseModelImpl() {
        eventtDataRepository = new HashMap<>();
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
                delegate.onSuccess(houses);
            }

            @Override
            public void onFail(String errorMessage) {
                delegate.onFailure(errorMessage);
            }
        });
    }
}
