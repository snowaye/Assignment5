package com.padc.batch9.assignment5.activity.network.dataagent;

import android.util.Log;

import com.google.gson.Gson;
import com.padc.batch9.assignment5.activity.network.response.GetHousesResponse;
import com.padc.batch9.assignment5.activity.util.HouseConstant;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.padc.batch9.assignment5.activity.util.HouseConstant.BASE_URL;

public class RetrofitHouseAgentImpl implements HouseDataAgent{

    private static RetrofitHouseAgentImpl objInstance;
    private HouseApi houseApi;

    private RetrofitHouseAgentImpl() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.level(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(15, TimeUnit.SECONDS)
                .writeTimeout(15, TimeUnit.SECONDS)
                .readTimeout(15, TimeUnit.SECONDS)
                .addInterceptor(interceptor)
                .build();


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();
        houseApi = retrofit.create(HouseApi.class);
    }

    public static RetrofitHouseAgentImpl getObjInstance() {
        if (objInstance==null)
            objInstance = new RetrofitHouseAgentImpl();
        return objInstance;
    }

    @Override
    public void getHouse(final GetHouseFromNetworkDelegate delegate) {
        Log.i("TAG", "Retrofit GEt House");
        Call<GetHousesResponse> call = houseApi.getAllHouses();

        Log.i("TAG", "Call");
        call.enqueue(new Callback<GetHousesResponse>() {
            @Override
            public void onResponse(Call<GetHousesResponse> call, Response<GetHousesResponse> response) {
                Log.i("TAG", "call"+call.toString());
                Log.i("TAG", "houseList="+response.body());
                Log.i("TAG", "resonseOk="+response.body().isResponseOk());
                Log.i("TAG", "responseCode="+response.body().getErrorCode());
                Log.i("TAG", "resonseOk="+response.body().getErrorMessage());


                if (response!=null) {
                    if (response.isSuccessful()) {
                        Log.i("TAG", "houseList="+response.body().getHouseVoList().size());
                        Log.i("TAG", "resonseOk="+response.body().isResponseOk());
                        Log.i("TAG", "responseCode="+response.body().getErrorCode());
                        Log.i("TAG", "resonseOk="+response.body().getErrorMessage());
                        Log.i("TAG", "houseList="+response.body().getHouseVoList().size());
                        delegate.onSuccess(response.body().getHouseVoList());
                    }
                    else {
                        delegate.onFailure(response.body().getErrorMessage());
                    }
                }
            }

            @Override
            public void onFailure(Call<GetHousesResponse> call, Throwable t) {
                delegate.onFailure(t.getMessage());
            }
        });

    }
}
