package com.example.lab2.Thi12_8;

public class HDCT {
    private String SoLuongXuat,DonGiaXuat;

    public HDCT(String soLuongXuat, String donGiaXuat) {
        SoLuongXuat = soLuongXuat;
        DonGiaXuat = donGiaXuat;
    }

    public HDCT() {
    }

    public String getSoLuongXuat() {
        return SoLuongXuat;
    }

    public void setSoLuongXuat(String soLuongXuat) {
        SoLuongXuat = soLuongXuat;
    }

    public String getDonGiaXuat() {
        return DonGiaXuat;
    }

    public void setDonGiaXuat(String donGiaXuat) {
        DonGiaXuat = donGiaXuat;
    }
}
