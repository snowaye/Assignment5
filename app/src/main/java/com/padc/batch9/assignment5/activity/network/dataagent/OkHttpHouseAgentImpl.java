package com.padc.batch9.assignment5.activity.network.dataagent;

import android.os.AsyncTask;

import com.google.gson.Gson;
import com.padc.batch9.assignment5.activity.network.response.GetHousesResponse;
import com.padc.batch9.assignment5.activity.util.HouseConstant;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class OkHttpHouseAgentImpl implements HouseDataAgent{

    private static OkHttpHouseAgentImpl objInstance;
    private OkHttpClient okHttpClient;

    private OkHttpHouseAgentImpl() {
        okHttpClient = new OkHttpClient.Builder().
                connectTimeout(15, TimeUnit.SECONDS)
                .writeTimeout(15,  TimeUnit.SECONDS)
                .readTimeout(15, TimeUnit.SECONDS)
                .build();
    }

    public static OkHttpHouseAgentImpl getObjInstance() {
        if (objInstance==null)
            objInstance = new OkHttpHouseAgentImpl();
        return objInstance;
    }

    @Override
    public void getHouse(GetHouseFromNetworkDelegate delegate) {
        new GetHouseDataTaskWithOkHttp(HouseConstant.DUMMY_ACCESS_TOKEN, delegate, okHttpClient)
                .execute();
    }

    private static class GetHouseDataTaskWithOkHttp extends AsyncTask<Void, Void, GetHousesResponse> {
        String accessToken;
        GetHouseFromNetworkDelegate delegate;
        OkHttpClient client;

        public GetHouseDataTaskWithOkHttp(String accessToken, GetHouseFromNetworkDelegate delegate, OkHttpClient client) {
            this.accessToken = accessToken;
            this.delegate = delegate;
            this.client = client;
        }

        @Override
        protected GetHousesResponse doInBackground(Void... voids) {
            String url = HouseConstant.BASE_URL+HouseConstant.GET_HOUSE;
            RequestBody requestBody = new FormBody.Builder()
                    .add(HouseConstant.PARAM_ACCESS_TOKEN, HouseConstant.DUMMY_ACCESS_TOKEN)
                    .build();
            Request request = new Request.Builder()
                    .url(url)
                    .post(requestBody)
                    .build();
            try {
                Response response = client.newCall(request).execute();
                if (response.isSuccessful()) {
                    String responseString = response.body().string();
                    GetHousesResponse housesResponse = new Gson().fromJson(responseString,
                            GetHousesResponse.class);
                    return housesResponse;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(GetHousesResponse housesResponse) {
            super.onPostExecute(housesResponse);
            if (housesResponse!=null) {
                if (housesResponse.isResponseOk()) {
                    delegate.onSuccess(housesResponse.getHouseVoList());
                }
                else {
                    delegate.onFailure(housesResponse.getErrorMessage());
                }
            }
            else {
                delegate.onFailure(HouseConstant.EM_NULL_RESPONSE);
            }
        }
    }
}
