package com.example.lab2.Demo5;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.lab2.R;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Demo51Activity extends AppCompatActivity {
    EditText txt1,txt2,txt3,txt4;
    Button btn1,btn2,btn3;
    TextView tvKQ;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo51);
        txt1=findViewById(R.id.txt1);
        txt2=findViewById(R.id.txt2);
        txt3=findViewById(R.id.txt3);
        txt4=findViewById(R.id.txt4);
        btn1=findViewById(R.id.btn1);
        btn2=findViewById(R.id.btn2);
        btn3=findViewById(R.id.btn3);
        tvKQ=findViewById(R.id.tvKQ);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SelectRetrofit();
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UpdateRetrofit();
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DeleteRetrofit();
            }
        });
    }

    private void DeleteRetrofit() {
        Prod p=new Prod();
        p.setPid(txt1.getText().toString());
        Retrofit retrofit=new Retrofit.Builder().baseUrl("http://batdongsanabc.000webhostapp.com/mob403lab5/")
                .addConverterFactory(GsonConverterFactory.create()).build();
        InterfaceDelete interfaceDelete=retrofit.create(InterfaceDelete.class);
        Call<SvrResponseDelete> call=interfaceDelete.deleteData(p.getPid());
        call.enqueue(new Callback<SvrResponseDelete>() {
            @Override
            public void onResponse(Call<SvrResponseDelete> call, Response<SvrResponseDelete> response) {
                SvrResponseDelete svrResponseDelete=response.body();
                tvKQ.setText(svrResponseDelete.getMessage());
            }

            @Override
            public void onFailure(Call<SvrResponseDelete> call, Throwable t) {
                tvKQ.setText(t.getMessage());
            }
        });
    }

    private void UpdateRetrofit() {
        Prod p=new Prod();
        p.setPid(txt1.getText().toString());
        p.setName(txt2.getText().toString());
        p.setPrice(txt3.getText().toString());
        p.setDes(txt4.getText().toString());
        Retrofit retrofit=new Retrofit.Builder().baseUrl("http://batdongsanabc.000webhostapp.com/mob403lab5/")
                .addConverterFactory(GsonConverterFactory.create()).build();
        InterfaceUpdate interfaceUpdate=retrofit.create(InterfaceUpdate.class);
        Call<SvrResponseUpdate> call=interfaceUpdate.updateData(p.getPid(),p.getName(),p.getPrice(),p.getDes());
        call.enqueue(new Callback<SvrResponseUpdate>() {
            @Override
            public void onResponse(Call<SvrResponseUpdate> call, Response<SvrResponseUpdate> response) {
                SvrResponseUpdate svrResponseUpdate=response.body();
                tvKQ.setText(svrResponseUpdate.getMessage());
            }

            @Override
            public void onFailure(Call<SvrResponseUpdate> call, Throwable t) {
                tvKQ.setText(t.getMessage());
            }
        });
    }
    String strKQ="";
    ArrayList<Prod> ls;
    private void SelectRetrofit() {
        Retrofit retrofit=new Retrofit.Builder().baseUrl("http://batdongsanabc.000webhostapp.com/mob403lab4/")
                .addConverterFactory(GsonConverterFactory.create()).build();
        InterSelect interSelect=retrofit.create(InterSelect.class);
        Call<SvrResponseSelectData> call=interSelect.selectData();
        call.enqueue(new Callback<SvrResponseSelectData>() {
            @Override
            public void onResponse(Call<SvrResponseSelectData> call, Response<SvrResponseSelectData> response) {
                SvrResponseSelectData svrResponseSelectData=response.body();
                ls=new ArrayList<>(Arrays.asList(svrResponseSelectData.getProducts()));
                strKQ="";
                for(Prod p:ls){
                    strKQ +="Pid: "+p.getPid()+"  -  "+p.getName()+"  -  "+p.getPrice()+"  -  "+p.getDes()+"\n";
                }
                tvKQ.setText(strKQ);
            }

            @Override
            public void onFailure(Call<SvrResponseSelectData> call, Throwable t) {

            }
        });
    }
}