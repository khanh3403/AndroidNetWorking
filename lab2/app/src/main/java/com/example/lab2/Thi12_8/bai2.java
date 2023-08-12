package com.example.lab2.Thi12_8;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.lab2.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.DecimalFormat;

public class bai2 extends AppCompatActivity {
    EditText TenTL,TenSP,SLNhap,NgayNhap,DonGiaNhap,NgayHD,SoLuongXuat,DonGiaXuat;
    Button Nhap,Xuat;
    DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
    DatabaseReference theloai1,hdct1,hoadon1,sanpham1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai2);
        theloai1 = FirebaseDatabase.getInstance().getReference("theLoaiPH21056Khanhbn");
        hdct1 = FirebaseDatabase.getInstance().getReference("hdctPH21056Khanhbn");
        hoadon1 = FirebaseDatabase.getInstance().getReference("hoadonPH21056Khanhbn");
        sanpham1 = FirebaseDatabase.getInstance().getReference("sanphamPH21056Khanhbn");
        TenTL=findViewById(R.id.theLoai);
        TenSP=findViewById(R.id.tenSP);
        SLNhap=findViewById(R.id.soLuongNhap);
        NgayNhap=findViewById(R.id.ngayNhap);
        DonGiaNhap=findViewById(R.id.donGiaNhap);
        NgayHD=findViewById(R.id.NgayHD);
        SoLuongXuat=findViewById(R.id.SoLuongXuat);
        DonGiaXuat=findViewById(R.id.DonGiaXuat);
        Nhap=findViewById(R.id.Nhap);
        Xuat=findViewById(R.id.Xuat);
        Nhap.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                theloai1.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        theloai theloai = new theloai(TenTL.getText().toString());
                        theloai1.child(TenTL.getText().toString()).setValue(theloai);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
                hdct1.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        HDCT hdct=new HDCT(SoLuongXuat.getText().toString(),DonGiaXuat.getText().toString());
                        hdct1.child(SoLuongXuat.getText().toString()).setValue(hdct);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
                hoadon1.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        hoadon hoadon=new hoadon(NgayHD.getText().toString());
                        hoadon1.child(NgayHD.getText().toString()).setValue(hoadon);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
                sanpham1.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        sanpham sanpham=new sanpham(TenSP.getText().toString(),SLNhap.getText().toString(),NgayNhap.getText().toString(),DonGiaNhap.getText().toString());
                        sanpham1.child(TenSP.getText().toString()).setValue(sanpham);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
            }
        });
        Toast.makeText(this, "ThanhCong", Toast.LENGTH_SHORT).show();
    }

}