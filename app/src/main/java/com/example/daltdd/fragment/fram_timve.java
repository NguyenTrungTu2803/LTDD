package com.example.daltdd;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.Toast;

//import com.example.daltdd.class_searchplace.search_go_come;

import java.util.Calendar;

public class fram_timve extends Fragment {

    private CalendarView cal_buttom;
    private EditText editgo, editcome;
    private Button cal_li2, homnay, ngaymai, timve;
    private  View view;
    public fram_timve() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_fram_timve, container, false);
        AnhXa();
        DateNow();
        fl_chuyendoi_click(view);
        cal_li2_click(view);
        TimVe();
        return view ;
    }
    private void AnhXa(){
        cal_buttom = view.findViewById(R.id.cal_bottom);
        cal_li2 = view.findViewById(R.id.cal_li2);
        homnay = view.findViewById(R.id.btn_homnay);
        ngaymai = view.findViewById(R.id.btn_ngaymai);
        editcome = view.findViewById(R.id.txt_noiden);
        editgo = view.findViewById(R.id.txt_noidi);
        timve = view.findViewById(R.id.btn_timvere);
    }
    private void DateNow(){
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DATE,Calendar.getInstance().getActualMinimum(Calendar.DATE));
        long date = calendar.getTime().getTime();

        //cal_li2.setText(s);
        cal_buttom.setMinDate(date);
    }

    public void fl_chuyendoi_click(View view) {

    }

    public void cal_li2_click(View view) {
        cal_buttom.setVisibility(View.INVISIBLE);
        cal_li2.setText(R.string.chonngaydi);
        cal_li2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(cal_li2.getText() == getString(R.string.chonngaydi)) {
                    cal_buttom.setVisibility(View.VISIBLE);
                    cal_li2.setText("");
                }
                else if(cal_li2.getText() == "") {
                    cal_buttom.setVisibility(View.INVISIBLE);
                    cal_li2.setText(R.string.chonngaydi);
                }
            }
        });

    }
    public void go_come(){
        editgo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent intent = new Intent(getActivity(), search_go_come.class);
                //startActivity(intent);
            }
        });
        editcome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent intent = new Intent(getActivity(), search_go_come.class);
                //startActivity(intent);
            }
        });
    }
    public void TimVe(){
        timve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(editcome.getText().toString()!= "" && editgo.getText().toString() != ""){
                    Intent intent= new Intent(getActivity(), thongtintimve.class);
                    startActivity(intent);
                }
                else
                    Toast.makeText(getActivity(), "Chưa nhập đầu đủ thông tin", Toast.LENGTH_LONG).show();
            }
        });
    }
}
