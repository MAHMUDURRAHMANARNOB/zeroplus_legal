package com.zeroplus.zeroplus_legal;

import com.zeroplus.zeroplus_legal.lawChamber.Interfaces.JsonPlaceHolderApi;

import kotlin.jvm.Synchronized;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class apiController {
    private static final String url = "https://zeroplus.world/api/";
    private static apiController clientObject;
    private static Retrofit retrofit;

    public apiController() {
        retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static synchronized apiController getInstance(){
        if(clientObject == null){
            clientObject = new apiController();
        }
        return clientObject;
    }

    JsonPlaceHolderApi getApi(){
        return retrofit.create(JsonPlaceHolderApi.class);
    }
}
