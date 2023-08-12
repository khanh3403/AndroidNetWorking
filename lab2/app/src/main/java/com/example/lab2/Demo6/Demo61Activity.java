package com.example.lab2.Demo6;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.lab2.R;

public class Demo61Activity extends AppCompatActivity {
    Button btn;
    TextView tvResuilt;
    FunctionGetDataVolley fn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo61);
        btn=findViewById(R.id.btn1);
        tvResuilt=findViewById(R.id.tvResult2);
        fn=new FunctionGetDataVolley();
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fn.getStringVolley(Demo61Activity.this,tvResuilt);
            }
        });

    }
}