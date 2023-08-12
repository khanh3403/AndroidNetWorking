package com.example.lab2.Thi12_8;

public class sanpham {
    private String tenSP,SoLuongNhap,NgayNhap,DonGiaNhap;

    public sanpham(String tenSP, String soLuongNhap, String ngayNhap, String donGiaNhap) {
        this.tenSP = tenSP;
        SoLuongNhap = soLuongNhap;
        NgayNhap = ngayNhap;
        DonGiaNhap = donGiaNhap;
    }

    public sanpham() {
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public String getSoLuongNhap() {
        return SoLuongNhap;
    }

    public void setSoLuongNhap(String soLuongNhap) {
        SoLuongNhap = soLuongNhap;
    }

    public String getNgayNhap() {
        return NgayNhap;
    }

    public void setNgayNhap(String ngayNhap) {
        NgayNhap = ngayNhap;
    }

    public String getDonGiaNhap() {
        return DonGiaNhap;
    }

    public void setDonGiaNhap(String donGiaNhap) {
        DonGiaNhap = donGiaNhap;
    }
}
