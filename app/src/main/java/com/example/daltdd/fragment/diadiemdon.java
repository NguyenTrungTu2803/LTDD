package com.example.daltdd.fragment;


import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.daltdd.R;
import com.example.daltdd.class_arraylist.DiaDiem;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

/**
 * A simple {@link Fragment} subclass.
 */
public class diadiemdon extends Fragment{

    private  View view;
    public RadioButton ra1,ra2,ra3,ra4,ra5,ra6,ra7;
    public TextView tv1_1, tv2_1,tv3_1,tv4_1,tv5_1,tv6_1,tv7_1;
    public TextView tv1_2, tv2_2,tv3_2,tv4_2,tv5_2,tv6_2,tv7_2;
    private DatabaseReference reference;
    DiaDiem diaDiem = new DiaDiem();
    public String tv;
    String k;
    public diadiemdon() {
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_diadiemdon, container, false);
        Bundle bundle = getArguments();
        k = bundle.getString("ghechon");
        //tv1_1.setText(k);
        reference = FirebaseDatabase.getInstance().getReference("a1a2");
        AnhXa();
        AnhXaRad();
        //Add();
        return view;
    }
    public void AnhXa(){
        ra1 = view.findViewById(R.id.rad1);
        ra2 = view.findViewById(R.id.rad2);
        ra3 = view.findViewById(R.id.rad3);
        ra4 = view.findViewById(R.id.rad4);
        ra5 = view.findViewById(R.id.rad5);
        ra6 = view.findViewById(R.id.rad6);
        ra7 = view.findViewById(R.id.rad7);
        tv1_1 = view.findViewById(R.id.tv1_1);
        tv2_1 = view.findViewById(R.id.tv2_1);
        tv3_1 = view.findViewById(R.id.tv3_1);
        tv4_1 = view.findViewById(R.id.tv4_1);
        tv5_1 = view.findViewById(R.id.tv5_1);
        tv6_1 = view.findViewById(R.id.tv6_1);
        tv7_1 = view.findViewById(R.id.tv7_1);

        tv1_2 = view.findViewById(R.id.tv1_2);
        tv2_2 = view.findViewById(R.id.tv2_2);
        tv3_2 = view.findViewById(R.id.tv3_2);
        tv4_2 = view.findViewById(R.id.tv4_2);
        tv5_2 = view.findViewById(R.id.tv5_2);
        tv6_2 = view.findViewById(R.id.tv6_2);
        tv7_2 = view.findViewById(R.id.tv7_2);
    }
    public void EventClick(RadioButton rad, final String s){
            rad.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if(isChecked) {
                        tv = s;
                        Toast.makeText(getActivity(), k, Toast.LENGTH_SHORT).show();
                        reference.addValueEventListener(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                    reference.getRef().child("DiaChiDon").setValue(tv);
                                //reference.child("DiaChiDon").setValue(tv);
                            }

                            @Override
                            public void onCancelled(@NonNull DatabaseError databaseError) {

                            }
                        });
                       // Toast.makeText(getActivity(), tv, Toast.LENGTH_SHORT).show();
                    }
                }
            });

    }
    public void AnhXaRad(){
        EventClick(ra1, tv1_1.getText().toString());
        EventClick(ra2, tv2_1.getText().toString());
        EventClick(ra3, tv3_1.getText().toString());
        EventClick(ra4, tv4_1.getText().toString());
        EventClick(ra5, tv5_1.getText().toString());
        EventClick(ra6, tv6_1.getText().toString());
        EventClick(ra7, tv7_1.getText().toString());
    }
    public void Add(){


    }
}
