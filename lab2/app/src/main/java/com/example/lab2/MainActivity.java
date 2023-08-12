package com.example.lab2;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lab2.Demo2.CNAsync;
import com.example.lab2.Demo2.Demo21Inteface;

public class MainActivity extends AppCompatActivity implements Demo21Inteface,
            View.OnClickListener{
    Button button;
    TextView textview;
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textview=findViewById(R.id.textview);
        imageView=findViewById(R.id.demo21ImageView);
        button=findViewById(R.id.btnDemo21);
        button.setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {
        new CNAsync(this,this).execute("http://i64.tinypic.com/28vaq8k.png");
    }
    @Override
    public void onLoadBitmap(Bitmap bitmap) {
        imageView.setImageBitmap(bitmap);
        textview.setText("load du lieu thanh cong");
    }

    @Override
    public void onError() {
        textview.setText("loi load du lieu");
    }


}