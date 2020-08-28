package com.example.daltdd.class_arraylist;

public class DiaDiem {
    public  DiaDiem(){

    }
    public String getDdd() {
        return ddd;
    }

    public void setDdd(String ddd) {
        this.ddd = ddd;
    }

    public String getDdtr() {
        return ddtr;
    }

    public void setDdtr(String ddtr) {
        this.ddtr = ddtr;
    }

    public String ddd;

    public DiaDiem(String ddd, String ddtr) {
        this.ddd = ddd;
        this.ddtr = ddtr;
    }

    public String ddtr;
}
