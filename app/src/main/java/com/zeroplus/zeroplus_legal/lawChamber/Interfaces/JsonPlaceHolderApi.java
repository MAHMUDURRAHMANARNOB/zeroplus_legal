package com.zeroplus.zeroplus_legal.lawChamber.Interfaces;

import com.zeroplus.zeroplus_legal.ResponseModels.loginResponseModel;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface JsonPlaceHolderApi {

    @FormUrlEncoded
    @POST("auth/login")
    Call<loginResponseModel> getLoginInfo(
            @Field("email") String Email,
            @Field("password") String Password
    );


}
