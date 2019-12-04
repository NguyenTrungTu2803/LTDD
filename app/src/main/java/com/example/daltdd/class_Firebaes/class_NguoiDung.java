package com.example.daltdd.class_Firebaes;

public class class_NguoiDung {
    public String sdt, ten, email, matkhau;
    public class_NguoiDung(){
    }
    public  class_NguoiDung(String sdt, String ten, String email, String matkhau){
        this.sdt = sdt;
        this.ten = ten;
        this.email = email;
        this.matkhau = matkhau;
    }
    public String getSdt() {
        return sdt;
    }

    public String getTen() {
        return ten;
    }

    public String getEmail() {
        return email;
    }

    public String getMatkhau() {
        return matkhau;
    }
}
