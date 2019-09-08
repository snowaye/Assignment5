package com.padc.batch9.assignment5.activity.data.vo.model;

import com.padc.batch9.assignment5.activity.network.dataagent.HouseDataAgent;
import com.padc.batch9.assignment5.activity.network.dataagent.OkHttpHouseAgentImpl;
import com.padc.batch9.assignment5.activity.network.dataagent.RetrofitHouseAgentImpl;

public abstract class BaseModel {

    protected HouseDataAgent mDataAgent;

    public BaseModel() {
        mDataAgent = RetrofitHouseAgentImpl.getObjInstance();
    }
}
