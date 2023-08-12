package com.example.asmagile.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.example.asmagile.Adapter.ViewPageAdapter;
import com.example.asmagile.Fragment.FragmentBanHang;
import com.example.asmagile.Fragment.FragmentBaoCao;
import com.example.asmagile.Fragment.FragmentHoaDon;
import com.example.asmagile.Fragment.FragmentThem;
import com.example.asmagile.R;
import com.google.android.material.tabs.TabLayout;

public class MatHangActivity extends AppCompatActivity {
    ViewPager viewPager;
    public TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mat_hang);
        tabLayout=findViewById(R.id.TabLayout);
        viewPager=findViewById(R.id.viewPage);

        ViewPageAdapter viewPageAdapter=new ViewPageAdapter(getSupportFragmentManager());
        viewPageAdapter.addFragment(new FragmentBanHang(),"Bán Hàng");
        viewPageAdapter.addFragment(new FragmentHoaDon(),"Hóa Đơn");
        viewPageAdapter.addFragment(new FragmentBaoCao(),"Báo Cáo");
        viewPageAdapter.addFragment(new FragmentThem(),"Thêm");
        viewPager.setAdapter(viewPageAdapter);

        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setIcon(R.drawable.iconbanhangactivity);
        tabLayout.getTabAt(1).setIcon(R.drawable.iconhoadonactivity);
        tabLayout.getTabAt(2).setIcon(R.drawable.iconbaocaoactivity);
        tabLayout.getTabAt(3).setIcon(R.drawable.iconthemactivity);
    }
}