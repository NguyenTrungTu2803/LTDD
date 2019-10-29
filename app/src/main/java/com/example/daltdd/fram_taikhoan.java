package com.example.daltdd;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;


/**
 * A simple {@link Fragment} subclass.
 */
public class fram_taikhoan extends Fragment {

    private FrameLayout fram1,fram2, fram3, fram4, fram5, fram6, fram7, fram8, fram9;
    private fram_taikhoan fram_taikhoan;
    public fram_taikhoan() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        clickFram();
        return inflater.inflate(R.layout.fragment_fram_taikhoan, container, false);
    }
    public void clickFram(){

    }
}
