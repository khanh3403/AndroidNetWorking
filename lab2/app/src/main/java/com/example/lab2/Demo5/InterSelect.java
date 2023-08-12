package com.example.lab2.Demo5;

import retrofit2.Call;
import retrofit2.http.GET;

public interface InterSelect {
    @GET("get_all_product.php")
    Call<SvrResponseSelectData> selectData();
}
