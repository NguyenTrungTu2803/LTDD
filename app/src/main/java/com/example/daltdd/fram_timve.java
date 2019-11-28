package com.example.daltdd;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;

import java.util.Calendar;

public class fram_timve extends Fragment {

    private CalendarView cal_li2, cal_buttom;
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
        return view ;
    }
    private void AnhXa(){
        cal_buttom = view.findViewById(R.id.cal_bottom);
        cal_li2 = view.findViewById(R.id.cal_li2);
    }
    private void DateNow(){
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DATE,Calendar.getInstance().getActualMinimum(Calendar.DATE));
        long date = calendar.getTime().getTime();
        cal_li2.setMinDate(date);
        cal_buttom.setMinDate(date);
    }

}
