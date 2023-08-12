package com.example.asmagile.Fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.asmagile.Activity.KhachHangActivity;
import com.example.asmagile.Activity.LoaiSanPhamActivity;
import com.example.asmagile.Activity.SanPhamActivity;
import com.example.asmagile.R;
import com.google.android.material.navigation.NavigationView;


public class FragmentThem extends Fragment {

    TextView tvMatHang, tvPhanLoai, tvDonViTinh, tvNguoiDung;
    ImageView imgMatHang, imgPhanLoai, imgDonViTinh, imgNguoiDung;
    androidx.appcompat.widget.Toolbar toolbar;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_them, container, false);
        anhXaView(view);

        imgMatHang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chuyenAct(SanPhamActivity.class);
            }
        });
        tvMatHang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chuyenAct(SanPhamActivity.class);
            }
        });

        //chuyển sang loại sản phẩm activity
        imgPhanLoai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chuyenAct(LoaiSanPhamActivity.class);
            }
        });
        tvPhanLoai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chuyenAct(LoaiSanPhamActivity.class);
            }
        });

        //chuyển sang đơn vị tính activity


        //-> người dùng act
        imgNguoiDung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chuyenAct(KhachHangActivity.class);
            }
        });
        tvNguoiDung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chuyenAct(KhachHangActivity.class);
            }
        });
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        anhXaView(view);
    }

    public void anhXaView(View view) {
        tvMatHang = view.findViewById(R.id.tvMatHang);
        tvPhanLoai = view.findViewById(R.id.tvPhanLoai);
        tvDonViTinh = view.findViewById(R.id.tvDonViTinh);
        tvNguoiDung = view.findViewById(R.id.tvNguoiDung);
        imgMatHang = view.findViewById(R.id.imgMatHang);
        imgPhanLoai = view.findViewById(R.id.imgPhanLoai);
        imgDonViTinh = view.findViewById(R.id.imgDonViTinh);
        imgNguoiDung = view.findViewById(R.id.imgNguoiDung);
        toolbar = view.findViewById(R.id.toolbar_thong_tin);
        drawerLayout = view.findViewById(R.id.drawerLayoutThem);
        navigationView = view.findViewById(R.id.NavigationViewThem);
    }
    public void chuyenAct(Class aClass) {
        Intent intent = new Intent(getActivity(), aClass);
        startActivity(intent);
    }
}