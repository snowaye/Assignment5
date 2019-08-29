package com.padc.batch9.assignment5.activity.network.dataagent;

import com.padc.batch9.assignment5.activity.data.vo.HouseVo;

import java.util.List;

public interface HouseDataAgent {

    public void getHouse(GetHouseFromNetworkDelegate delegate);

    public interface GetHouseFromNetworkDelegate {
        public void onSuccess(List<HouseVo> houses);
        public void onFail(String errorMessage);
    }
}
