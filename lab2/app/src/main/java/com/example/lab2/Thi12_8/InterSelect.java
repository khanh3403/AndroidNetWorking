package com.example.lab2.Thi12_8;



import retrofit2.Call;
import retrofit2.http.GET;

public interface InterSelect {
    @GET("Insert.php")
    Call<SvrResponseSelectData2> selectData();
}
