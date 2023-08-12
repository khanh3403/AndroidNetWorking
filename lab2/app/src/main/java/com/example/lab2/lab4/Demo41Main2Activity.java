package com.example.lab2.lab4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.lab2.R;
import com.example.lab2.lab4.insert.InterfacePrd;
import com.example.lab2.lab4.insert.Prd;
import com.example.lab2.lab4.insert.SvrResponsePrd;
import com.example.lab2.lab4.select.InterfaceSelect;
import com.example.lab2.lab4.select.Prod;
import com.example.lab2.lab4.select.ServerResponseProd;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Demo41Main2Activity extends AppCompatActivity {
    EditText edName,edPrice,edDes;
    Button btnUpdate,btnGet;
    TextView tvResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo41_main2);
        edName=findViewById(R.id.edName);
        edPrice=findViewById(R.id.edPrice);
        edDes=findViewById(R.id.edDes);
        btnGet=findViewById(R.id.btnGet);
        tvResult=findViewById(R.id.tvResult);
        btnUpdate=findViewById(R.id.btnUpdate2);
        btnGet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectData();
            }
        });
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                insertData();
            }
        });
    }
    String strKQ="";
    List<Prod> ls;
    public void selectData(){
        Retrofit retrofit=new Retrofit.Builder().baseUrl("https://batdongsanabc.000webhostapp.com/mob403lab5/")
                .addConverterFactory(GsonConverterFactory.create()).build();
        InterfaceSelect interfaceSelect=retrofit.create(InterfaceSelect.class);
        Call<ServerResponseProd> call=interfaceSelect.getProd();
        call.enqueue(new Callback<ServerResponseProd>() {
            @Override
            public void onResponse(Call<ServerResponseProd> call, Response<ServerResponseProd> response) {
                ServerResponseProd serverResponseProd=response.body();
                ls=new ArrayList<>(Arrays.asList(serverResponseProd.getProducts()));
                for(Prod p:ls){
                    strKQ+="Name: "+p.getName()+", Price: "+ p.getPrice()+", Des: "+p.getDescription()+"\n\n";
                }
                tvResult.setText(strKQ);
            }

            @Override
            public void onFailure(Call<ServerResponseProd> call, Throwable t) {

            }
        });
    }
    public void insertData(){
        Prd prd=new Prd();
        prd.setName(edName.getText().toString());
        prd.setPrice(edPrice.getText().toString());
        prd.setDescription(edDes.getText().toString());
        Retrofit retrofit=new Retrofit.Builder().baseUrl("https://batdongsanabc.000webhostapp.com/mob403lab4/")
                .addConverterFactory(GsonConverterFactory.create()).build();
        InterfacePrd insertPrdObj=retrofit.create(InterfacePrd.class);
        Call<SvrResponsePrd> call=insertPrdObj.insertPrd(prd.getName(), prd.getPrice(), prd.getDescription());
        call.enqueue(new Callback<SvrResponsePrd>() {
            @Override
            public void onResponse(Call<SvrResponsePrd> call, Response<SvrResponsePrd> response) {
                SvrResponsePrd svrResponsePrd=response.body();
                tvResult.setText(svrResponsePrd.getMessage());
            }

            @Override
            public void onFailure(Call<SvrResponsePrd> call, Throwable t) {
                tvResult.setText(t.getMessage());
            }
        });
    }
}