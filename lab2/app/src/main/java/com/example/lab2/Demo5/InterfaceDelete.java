package com.example.lab2.Demo5;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface InterfaceDelete {
    @FormUrlEncoded
    @POST("delete_product.php")
    Call<SvrResponseDelete> deleteData(@Field("pid") String pid);
}
