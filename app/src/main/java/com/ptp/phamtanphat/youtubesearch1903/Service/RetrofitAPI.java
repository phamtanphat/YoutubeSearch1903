package com.ptp.phamtanphat.youtubesearch1903.Service;

public class RetrofitAPI {

    private static final String base_url = "https://www.googleapis.com/youtube/v3/";

    public static DataAPI getDataAPI(){
        return RetrofitInit.getRetrofit(base_url).create(DataAPI.class);
    }
}
