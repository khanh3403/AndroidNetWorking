package com.example.lab2.Thi12_8;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.lab2.Demo5.InterSelect;
import com.example.lab2.Demo5.Prod;
import com.example.lab2.Demo5.SvrResponseSelectData;
import com.example.lab2.R;

import java.util.ArrayList;
import java.util.Arrays;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class De1Activity extends AppCompatActivity {
    Button btnSelect;
    TextView tvResult;
    Button btnBai2;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_de1);
        btnSelect=findViewById(R.id.Khanhbnph21056_select);
        tvResult=findViewById(R.id.Khanhbnph21056_Result);
        btnBai2=findViewById(R.id.idBai2);
        btnBai2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(De1Activity.this,bai2.class));
            }
        });
        btnSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Select();
            }
        });
    }
    String strKQ="";
    ArrayList<Prod> ls;
    private void Select() {
        Retrofit retrofit=new Retrofit.Builder().baseUrl("http://batdongsanabc.000webhostapp.com/mob403lab4/")
                .addConverterFactory(GsonConverterFactory.create()).build();
        com.example.lab2.Demo5.InterSelect interSelect=retrofit.create(InterSelect.class);
        Call<SvrResponseSelectData> call=interSelect.selectData();
        call.enqueue(new Callback<SvrResponseSelectData>() {
            @Override
            public void onResponse(Call<SvrResponseSelectData> call, Response<SvrResponseSelectData> response) {
                SvrResponseSelectData svrResponseSelectData=response.body();
                ls=new ArrayList<>(Arrays.asList(svrResponseSelectData.getProducts()));
                strKQ="";
                for(Prod p:ls){
                    strKQ +="Pid: "+p.getPid()+"  -  "+p.getName()+"  -  "+p.getPrice()+"\n";
                }
                tvResult.setText(strKQ);
            }

            @Override
            public void onFailure(Call<SvrResponseSelectData> call, Throwable t) {

            }
        });
    }
}