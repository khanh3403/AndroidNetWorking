package com.example.lab2.Demo6;

import android.app.DownloadManager;
import android.content.Context;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.io.StringReader;

public class FunctionGetDataVolley {
    public void getStringVolley(Context context, TextView textView){
        RequestQueue queue= Volley.newRequestQueue(context);
        String Url="https://www.google.com/";
        StringRequest stringRequest=new StringRequest(Request.Method.GET, Url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                textView.setText("Ketqua: "+response.substring(0,1000));
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                textView.setText(error.getMessage());
            }
        });
        queue.add(stringRequest);
    }
}
