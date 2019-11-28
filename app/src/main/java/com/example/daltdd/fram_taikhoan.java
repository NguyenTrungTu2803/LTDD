package com.example.daltdd;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.daltdd.class_arraylist.LayThongTinND;


public class fram_taikhoan extends Fragment implements View.OnClickListener {

    private FrameLayout fram1,fram2, fram3, fram4, fram5, fram6, fram7, fram8, fram9;
    private fram_taikhoan fram_taikhoan;
    private FrameLayout frameLayout;
    private LinearLayout lithongtin;
    private View view;
    public TextView viewtk, nametk;
    public fram_taikhoan() {
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_fram_taikhoan, container, false);
        findviewbyid();
        visibility();
        return  view;
    }
    @Override
    public void onClick(View v) {
        Intent intent = new Intent(getActivity(), DKDN.class);
        Intent caidat = new Intent(getActivity(), ngon_ngu.class);

        switch (v.getId()) {
            case R.id.fram_1:
                startActivity(intent);
                break;
            case R.id.fram_2:
                startActivity(intent);
                break;
            case R.id.fram_3:
                startActivity(intent);
                break;
            case R.id.fram_4:
                startActivity(intent);
                break;
            case R.id.fram_5:
                startActivity(intent);
                break;
            case R.id.fram_6:
                startActivity(intent);break;
            case R.id.fram_7:
                startActivity(caidat);
                break;
            case R.id.fram_8:
                startActivity(intent);break;
        }
    }
    public void findviewbyid(){
        fram1 = view.findViewById(R.id.fram_1);
        fram2 = view.findViewById(R.id.fram_2);
        fram3 = view.findViewById(R.id.fram_3);
        fram4 = view.findViewById(R.id.fram_4);
        fram5 = view.findViewById(R.id.fram_5);
        fram6 = view.findViewById(R.id.fram_6);
        fram7 = view.findViewById(R.id.fram_7);
        fram8 = view.findViewById(R.id.fram_8);
        fram9 = view.findViewById(R.id.fram_9);
        lithongtin = view.findViewById(R.id.thongtin);
        viewtk = view.findViewById(R.id.textViewtaikhoan);
        nametk = view.findViewById(R.id.manetaikhoan);
        fram1.setOnClickListener(this);
        fram3.setOnClickListener(this);
        fram4.setOnClickListener(this);
        fram5.setOnClickListener(this);
        fram6.setOnClickListener(this);
        fram7.setOnClickListener(this);
        fram8.setOnClickListener(this);
        fram2.setOnClickListener(this);
    }

    public  void visibility(){
        LayThongTinND layThongTinND = new LayThongTinND();
        Toast.makeText(getActivity(), layThongTinND.mTen, Toast.LENGTH_LONG).show();
        if(nametk.getText()!= null) {
            lithongtin.setVisibility(View.VISIBLE);
            viewtk.setVisibility(View.INVISIBLE);

        }else{
            lithongtin.setVisibility(View.INVISIBLE);
            viewtk.setVisibility(View.VISIBLE);
        }
    }
    public void fillTextview(String text){
        nametk.setText(text);
    }

}
