package com.example.lab2.Demo2;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;

import java.io.InputStream;
import java.net.URL;

public class CNAsync extends AsyncTask<String,Void, Bitmap> {
    private Demo21Inteface inteface;

    public CNAsync(Demo21Inteface inteface,Context context) {
        this.inteface = inteface;
    }

    //chuyen 1 chuoi va lay ve anh
    @Override
    protected Bitmap doInBackground(String... strings) {
        try {
            //lay anh ve theo huong dan
            return BitmapFactory.decodeStream((InputStream) new URL(strings[0]).getContent());
        }catch (Exception e){
            e.printStackTrace();
        };
        return null;
    }
    //output
    @Override
    protected void onPostExecute(Bitmap bitmap) {
        super.onPostExecute(bitmap);
        if(bitmap!=null){
            inteface.onLoadBitmap(bitmap);//tra kq cho interface
        }
        else {
            inteface.onError();
        }
    }
    //quatrinh
    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }
}
