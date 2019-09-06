package com.padc.batch9.assignment5.activity.network.dataagent;

import com.padc.batch9.assignment5.activity.network.response.GetHousesResponse;
import com.padc.batch9.assignment5.activity.util.HouseConstant;

import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface HouseApi {
    @POST(HouseConstant.GET_HOUSE)
    Call<GetHousesResponse> getAllHouses();
}
