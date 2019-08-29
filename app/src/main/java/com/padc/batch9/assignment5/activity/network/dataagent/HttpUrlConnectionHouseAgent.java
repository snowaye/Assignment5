package com.padc.batch9.assignment5.activity.network.dataagent;

import android.os.AsyncTask;

import com.google.gson.Gson;
import com.padc.batch9.assignment5.activity.network.dataagent.HouseDataAgent;
import com.padc.batch9.assignment5.activity.network.response.GetHousesResponse;
import com.padc.batch9.assignment5.activity.util.HouseConstant;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

public class HttpUrlConnectionHouseAgent implements HouseDataAgent {

    private static HttpUrlConnectionHouseAgent objInstance;

    private HttpUrlConnectionHouseAgent() {
    }

    public static HttpUrlConnectionHouseAgent getObjInstance() {
        if (objInstance==null)
            objInstance = new HttpUrlConnectionHouseAgent();
        return objInstance;
    }

    @Override
    public void getHouse(GetHouseFromNetworkDelegate delegate) {
        new GetHouseTask().execute();
    }

    private static class GetHouseTask extends AsyncTask<Void, Void, GetHousesResponse> {


        public GetHouseTask() {

        }

        @Override
        protected GetHousesResponse doInBackground(Void... voids) {
            URL url;
            BufferedReader reader = null;
            StringBuilder stringBuilder;

            try {
                url = new URL(HouseConstant.BASE_URL+
                        HouseConstant.GET_HOUSE);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("POST");
                connection.setReadTimeout(15 * 10000);
                connection.setDoInput(true);
                connection.setDoOutput(true);

                List<NameValuePair> params = new ArrayList<>();
                params.add(new BasicNameValuePair(HouseConstant.PARAM_ACCESS_TOKEN, HouseConstant.DUMMY_ACCESS_TOKEN));

                OutputStream outputStream = connection.getOutputStream();
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                writer.write(getQuery(params));
                writer.flush();
                writer.close();
                outputStream.close();
                connection.connect();

                reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                stringBuilder = new StringBuilder();
                String line = null;
                while ((line = reader.readLine()) != null) {
                    stringBuilder.append(line+"\n");
                }
                String responseString = stringBuilder.toString();
                GetHousesResponse response = new Gson().fromJson(responseString, GetHousesResponse.class);
                return response;

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return null;
        }
    }

    private static String getQuery(List<NameValuePair> params) throws UnsupportedEncodingException {
        StringBuilder result = new StringBuilder();
        boolean first = true;
        for (NameValuePair pair:params) {
            if (first) {
                first = false;
            }
            else
                result.append("&");
            result.append(URLEncoder.encode(pair.getName(), "UTF-8"));
            result.append("-");
            result.append(URLEncoder.encode(pair.getValue()));
        }
        return result.toString();
    }

}
