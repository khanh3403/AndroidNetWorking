package com.example.lab2.lab7;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DownloadManager;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.lab2.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class Demo71Activity extends AppCompatActivity {
    TextView tvResult;
    Button select,insert,update,delete;
    EditText pid,name,price,des;
    Context context=this;
    String strKQ="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo71);
        tvResult=findViewById(R.id.tvResult2);
        pid=findViewById(R.id.ed);
        name=findViewById(R.id.ed1);
        price=findViewById(R.id.ed2);
        des=findViewById(R.id.ed3);
        select=findViewById(R.id.btnSelect2);
        insert=findViewById(R.id.btnInsert);
        update=findViewById(R.id.btnUpdate2);
        delete=findViewById(R.id.btnDelete2);
        select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectVolley();
            }
        });
        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                insertVolley();
            }
        });
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateVolley();
            }
        });
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                deleteVolley();
            }
        });
    }

    private void insertVolley() {
        RequestQueue queue= Volley.newRequestQueue(context);
        String url="https://batdongsanabc.000webhostapp.com/mob403lab7/create_product.php";
        StringRequest request=new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                tvResult.setText(response.toString());
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                tvResult.setText(error.getMessage());
            }
        }){
            @Override
            protected Map<String, String> getParams() {
                Map<String,String> mydata=new HashMap<>();
                mydata.put("name",name.getText().toString());
                mydata.put("price",price.getText().toString());
                mydata.put("description",des.getText().toString());
                return mydata;
            }
        };
        queue.add(request);

    }

    private void updateVolley() {
        RequestQueue queue= Volley.newRequestQueue(context);
        String url="https://batdongsanabc.000webhostapp.com/mob403lab7/update_product.php";
        StringRequest request=new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                tvResult.setText(response.toString());
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                tvResult.setText(error.getMessage());
            }
        }){
            @Override
            protected Map<String, String> getParams() {
                Map<String,String> mydata=new HashMap<>();
                mydata.put("pid",pid.getText().toString());
                mydata.put("name",name.getText().toString());
                mydata.put("price",price.getText().toString());
                mydata.put("description",des.getText().toString());
                return mydata;
            }
        };
        queue.add(request);

    }

    private void deleteVolley() {
        RequestQueue queue= Volley.newRequestQueue(context);
        String url="https://batdongsanabc.000webhostapp.com/mob403lab7/delete_product.php";
        StringRequest request=new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                tvResult.setText(response.toString());
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                tvResult.setText(error.getMessage());
            }
        }){
            @Nullable
            @Override
            protected Map<String, String> getParams(){
                Map<String, String> mydata=new HashMap<>();
                mydata.put("pid",pid.getText().toString());
                return mydata;
            }
        };
        queue.add(request);
    }

    private void selectVolley() {
        RequestQueue queue= Volley.newRequestQueue(context);
        String url="https://batdongsanabc.000webhostapp.com/mob403lab7/get_all_product.php";
        JsonObjectRequest request=new JsonObjectRequest(url, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray product=response.getJSONArray("products");
                    strKQ="";
                    for(int i=0;i<product.length();i++){
                        JSONObject proObject=product.getJSONObject(i);
                        String pid=proObject.getString("pid");
                        String name =proObject.getString("name");
                        String price =proObject.getString("price");
                        String description =proObject.getString("description");
                        strKQ+="pid: "+pid+"\n";
                        strKQ+="name: "+name+"\n";
                        strKQ+="price: "+price+"\n";
                        strKQ+="description: "+description+"\n";
                    }
                    tvResult.setText(strKQ);
                }catch (JSONException e){
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                tvResult.setText(error.getMessage());

            }
        });
        queue.add(request);

    }
}