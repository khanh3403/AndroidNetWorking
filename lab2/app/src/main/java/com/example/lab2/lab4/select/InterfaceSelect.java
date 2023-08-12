package com.example.lab2.lab4.select;

import retrofit2.Call;
import retrofit2.http.GET;

public interface InterfaceSelect {
    @GET("get_all_product.php")
    Call<ServerResponseProd> getProd();
}
