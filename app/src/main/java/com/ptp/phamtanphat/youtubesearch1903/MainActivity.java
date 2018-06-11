package com.ptp.phamtanphat.youtubesearch1903;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.google.gson.Gson;
import com.ptp.phamtanphat.youtubesearch1903.Adapter.YoutubeAdapter;
import com.ptp.phamtanphat.youtubesearch1903.Model.Item;
import com.ptp.phamtanphat.youtubesearch1903.Model.ModelData;
import com.ptp.phamtanphat.youtubesearch1903.Service.DataAPI;
import com.ptp.phamtanphat.youtubesearch1903.Service.RetrofitAPI;
import com.ptp.phamtanphat.youtubesearch1903.Service.RetrofitInit;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    EditText edtSearch;
    Button btnSearch;
    ListView listView;
    YoutubeAdapter youtubeAdapter;
    ArrayList<Item> mangitem;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtSearch = findViewById(R.id.edittextSearch);
        btnSearch = findViewById(R.id.buttonSearch);
        listView = findViewById(R.id.listviewYoutube);
        DocDulieu("Phim");

        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tukhoa= edtSearch.getText().toString();
                tukhoa = tukhoa.replace(" " ,"%20");
                DocDulieu(tukhoa);
            }
        });

    }
    public void DocDulieu(String tukhoa){
        DataAPI dataAPI = RetrofitAPI.getDataAPI();
        Call<ModelData> callback = dataAPI.getResult("snippet",
                 tukhoa,
                "50",
                "video",
                "AIzaSyDw1xWgw-tzAEnKhPUpCPEpNXTwbs3e6hY");
        callback.enqueue(new Callback<ModelData>() {
            @Override
            public void onResponse(Call<ModelData> call, Response<ModelData> response) {
                ModelData modelData = response.body();

                mangitem = (ArrayList<Item>) modelData.getItems();
                youtubeAdapter = new YoutubeAdapter(MainActivity.this,android.R.layout.simple_list_item_1,mangitem);
                listView.setAdapter(youtubeAdapter);
            }

            @Override
            public void onFailure(Call<ModelData> call, Throwable t) {

            }
        });
    }
}
