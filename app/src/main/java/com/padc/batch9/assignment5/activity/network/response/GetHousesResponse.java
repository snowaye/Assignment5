package com.padc.batch9.assignment5.activity.network.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.padc.batch9.assignment5.activity.data.vo.HouseVo;
import com.padc.batch9.assignment5.activity.util.HouseConstant;

import java.util.List;

public class GetHousesResponse {
    @SerializedName("code")
    @Expose
    private int errorCode;

    @SerializedName("message")
    @Expose
    private String errorMessage;

    @SerializedName("data")
    @Expose
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

    public boolean isResponseOk() {
        if (errorCode== HouseConstant.CODE_RESPONSE_OK && houseVoList!=null)
            return true;
        else return false;
    }
}
