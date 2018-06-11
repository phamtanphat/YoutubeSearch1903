package com.ptp.phamtanphat.youtubesearch1903.Service;

import com.ptp.phamtanphat.youtubesearch1903.Model.ModelData;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface DataAPI {

    //Truyen ten link khong co dau ? search?part=snippet
    @GET("search")
    Call<ModelData> getResult(@Query("part") String part ,
                              @Query("q") String q ,
                              @Query("maxResults") String maxResults,
                              @Query("type") String type,
                              @Query("key") String key);

    //Link vi du : https://www.googleapis.com/youtube/v3/search/20/data
//    @GET("search/{id}/data")
//    Call<Object> getTrang(@Path("id") String id);
}
