package com.example.daltdd.class_Firebaes;

public class DSThongTinXe {

    public String TeXe;
    public String Gia;
    public  String SoGhe;
    public String BenXe;
    public String Gio;
    public String Ngay;

    public DSThongTinXe(){}
    public void setTeXe(String teXe) {
        TeXe = teXe;
    }

    public void setGia(String gia) {
        Gia = gia;
    }

    public void setSoGhe(String soGhe) {
        SoGhe = soGhe;
    }

    public void setBenXe(String benXe) {
        BenXe = benXe;
    }

    public void setGio(String gio) {
        Gio = gio;
    }

    public void setNgay(String ngay) {
        Ngay = ngay;
    }

    public String getTeXe() {
        return TeXe;
    }

    public String getGia() {
        return Gia;
    }

    public String getSoGhe() {
        return SoGhe;
    }

    public String getBenXe() {
        return BenXe;
    }
    public String getGio() {
        return Gio;
    }
    public String getNgay() {
        return Ngay;
    }


    public DSThongTinXe(String teXe, String gia, String soGhe, String benXe, String ngay, String gio) {
        TeXe = teXe;
        Gia = gia;
        SoGhe = soGhe;
        BenXe = benXe;
        Gio = gio;
        Ngay = ngay;
    }
}
