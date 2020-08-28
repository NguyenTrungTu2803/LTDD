package com.example.daltdd.fragment;


import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.daltdd.ChonDiaDiem;
import com.example.daltdd.R;
import com.example.daltdd.ThongTinKhach;
import com.example.daltdd.class_arraylist.DiaDiem;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

/**
 * A simple {@link Fragment} subclass.
 */
public class diadiemtra extends Fragment {

    DiaDiem diaDiem = new DiaDiem();
    private RadioButton ra1;
    private TextView tv1_1, tv1_2;
    private View view;

    public String getTv() {
        return tv;
    }
    private DatabaseReference reference;
    public String tv;
    public diadiemtra() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_diadiemtra, container, false);
        reference = FirebaseDatabase.getInstance().getReference("a1a2");
        AnhXa();
        AnhXaRad();
        return view;
    }
    public void AnhXa(){
        ra1 = view.findViewById(R.id.rad1);
        tv1_1 = view.findViewById(R.id.tv1_1);
        tv1_2 = view.findViewById(R.id.tv1_2);
    }
    public void EventClick(RadioButton rad, final String s){
        rad.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) {
                    tv = s;
                    reference.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            reference.getRef().child("DiaChiTra").setValue(tv);
                            //reference.child("DiaChiDon").setValue(tv);
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });
                }
                Intent intent = new Intent(getActivity(), ThongTinKhach.class);
                startActivity(intent);
            }
        });

    }
    public void AnhXaRad(){
        EventClick(ra1, tv1_1.getText().toString());
    }

}
