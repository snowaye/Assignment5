package com.padc.batch9.assignment5.activity.network.response;

import com.padc.batch9.assignment5.activity.data.vo.HouseVo;

import java.util.List;

public class GetHousesResponse {
    private int errorCode;
    private String errorMessage;
    private List<HouseVo> houseVoList;

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public List<HouseVo> getHouseVoList() {
        return houseVoList;
    }

    public void setHouseVoList(List<HouseVo> houseVoList) {
        this.houseVoList = houseVoList;
    }
}
