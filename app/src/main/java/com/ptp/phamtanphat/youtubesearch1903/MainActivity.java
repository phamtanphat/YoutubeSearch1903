package com.ptp.phamtanphat.youtubesearch1903;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.gson.Gson;
import com.ptp.phamtanphat.youtubesearch1903.Model.ModelData;
import com.ptp.phamtanphat.youtubesearch1903.Service.DataAPI;
import com.ptp.phamtanphat.youtubesearch1903.Service.RetrofitAPI;
import com.ptp.phamtanphat.youtubesearch1903.Service.RetrofitInit;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DataAPI dataAPI = RetrofitAPI.getDataAPI();
        Call<ModelData> callback = dataAPI.getResult("snippet",
                "phim",
                "50",
                "video",
                "AIzaSyDw1xWgw-tzAEnKhPUpCPEpNXTwbs3e6hY");
        callback.enqueue(new Callback<ModelData>() {
            @Override
            public void onResponse(Call<ModelData> call, Response<ModelData> response) {
                ModelData modelData = response.body();
                Log.d("BBB",modelData.getItems().get(0).getSnippet().getTitle());
            }

            @Override
            public void onFailure(Call<ModelData> call, Throwable t) {

            }
        });
    }
}
