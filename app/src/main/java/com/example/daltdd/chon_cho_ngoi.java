package com.example.daltdd;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.daltdd.class_Firebaes.SoGhe;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.Map;

public class chon_cho_ngoi extends Activity {
    private LinearLayout li4;
    private Button btn_chon;
    private int tong = 0;
    private String laysoghe = "";
    private TextView tongtien, chonghe;
    private ImageButton a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12;
    private ImageButton b1, b2, b3, b4, b5, b6, b7, b8, b9, b10, b11, b12;
    private  ImageButton c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12;
    private ImageButton d1, d2, d3, d4;
    private SoGhe soGhe = new SoGhe();
    private DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_chon_cho_ngoi);
        reference = FirebaseDatabase.getInstance().getReference("SoGhe40");
        AnhXa();
        EventChangeFirebaes();
        AnhXaClick();

    }
    void AnhXa(){
        tongtien = findViewById(R.id.txttonggia);
        chonghe = findViewById(R.id.txtsoghe);
        a1 = findViewById(R.id.a1);
        a2 = findViewById(R.id.a2);
        a3 = findViewById(R.id.a3);
        a4 = findViewById(R.id.a4);
        a5 = findViewById(R.id.a5);
        a6 = findViewById(R.id.a6);
        a7 = findViewById(R.id.a7);
        a8 = findViewById(R.id.a8);
        a9 = findViewById(R.id.a9);
        a10 = findViewById(R.id.a10);
        a11 = findViewById(R.id.a11);
        a12 = findViewById(R.id.a12);
        b1 = findViewById(R.id.b1);
        b2 = findViewById(R.id.b2);
        b3 = findViewById(R.id.b3);
        b4 = findViewById(R.id.b4);
        b5 = findViewById(R.id.b5);
        b6 = findViewById(R.id.b6);
        b7 = findViewById(R.id.b7);
        b8 = findViewById(R.id.b8);
        b9 = findViewById(R.id.b9);
        b10 = findViewById(R.id.b10);
        b11 = findViewById(R.id.b11);
        b12 = findViewById(R.id.b12);
        c1 = findViewById(R.id.c1);
        c2 = findViewById(R.id.c2);
        c3 = findViewById(R.id.c3);
        c4 = findViewById(R.id.c4);
        c5 = findViewById(R.id.c5);
        c6 = findViewById(R.id.c6);
        c7 = findViewById(R.id.c7);
        c8 = findViewById(R.id.c8);
        c9 = findViewById(R.id.c9);
        c10 = findViewById(R.id.c10);
        c11 = findViewById(R.id.c11);
        c12 = findViewById(R.id.c12);
        d1 = findViewById(R.id.d1);
        d2 = findViewById(R.id.d2);
        d3 = findViewById(R.id.d3);
        d4 = findViewById(R.id.d4);
        li4 = findViewById(R.id.li4);
        li4.setVisibility(View.INVISIBLE);
        btn_chon = findViewById(R.id.btn_chon);
        btn_chon.setVisibility(View.INVISIBLE);
    }
    void EventChangeFirebaes(){
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                setbackgound(dataSnapshot.child("b1").getValue().toString(), b1);

                setbackgound(dataSnapshot.child("a1").getValue().toString(), a1);
                setbackgound(dataSnapshot.child("a2").getValue().toString(), a2);
                setbackgound(dataSnapshot.child("a3").getValue().toString(), a3);
                setbackgound(dataSnapshot.child("a4").getValue().toString(), a4);
                setbackgound(dataSnapshot.child("a5").getValue().toString(), a5);
                setbackgound(dataSnapshot.child("a6").getValue().toString(), a6);
                setbackgound(dataSnapshot.child("a7").getValue().toString(), a7);
                setbackgound(dataSnapshot.child("a8").getValue().toString(), a8);
                setbackgound(dataSnapshot.child("a9").getValue().toString(), a9);
                setbackgound(dataSnapshot.child("a10").getValue().toString(), a10);
                setbackgound(dataSnapshot.child("a11").getValue().toString(), a11);
                setbackgound(dataSnapshot.child("a12").getValue().toString(), a12);

                setbackgound(dataSnapshot.child("b1").getValue().toString(), b1);
                setbackgound(dataSnapshot.child("b2").getValue().toString(), b2);
                setbackgound(dataSnapshot.child("b3").getValue().toString(), b3);
                setbackgound(dataSnapshot.child("b4").getValue().toString(), b4);
                setbackgound(dataSnapshot.child("b5").getValue().toString(), b5);
                setbackgound(dataSnapshot.child("b6").getValue().toString(), b6);
                setbackgound(dataSnapshot.child("b7").getValue().toString(), b7);
                setbackgound(dataSnapshot.child("b8").getValue().toString(), b8);
                setbackgound(dataSnapshot.child("b9").getValue().toString(), b9);
                setbackgound(dataSnapshot.child("b10").getValue().toString(), b10);
                setbackgound(dataSnapshot.child("b11").getValue().toString(), b11);
                setbackgound(dataSnapshot.child("b12").getValue().toString(), b12);

                setbackgound(dataSnapshot.child("c1").getValue().toString(), c1);
                setbackgound(dataSnapshot.child("c2").getValue().toString(), c2);
                setbackgound(dataSnapshot.child("c3").getValue().toString(), c3);
                setbackgound(dataSnapshot.child("c4").getValue().toString(), c4);
                setbackgound(dataSnapshot.child("c5").getValue().toString(), c5);
                setbackgound(dataSnapshot.child("c6").getValue().toString(), c6);
                setbackgound(dataSnapshot.child("c7").getValue().toString(), c7);
                setbackgound(dataSnapshot.child("c8").getValue().toString(), c8);
                setbackgound(dataSnapshot.child("c9").getValue().toString(), c9);
                setbackgound(dataSnapshot.child("c10").getValue().toString(), c10);
                setbackgound(dataSnapshot.child("c11").getValue().toString(), c11);
                setbackgound(dataSnapshot.child("c12").getValue().toString(), c12);

                setbackgound(dataSnapshot.child("d1").getValue().toString(), d1);
                setbackgound(dataSnapshot.child("d2").getValue().toString(), d2);
                setbackgound(dataSnapshot.child("d3").getValue().toString(), d3);
                setbackgound(dataSnapshot.child("d4").getValue().toString(), d4);
                //---------------------

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
    public void setbackgound(String s, final ImageButton im){
        if(s.equals("1")){
            im.setBackground(getDrawable(R.drawable.baseline_single_bed_black_48dp));
        }
        else if(s.equals("0")){
            im.setBackground(getDrawable(R.drawable.baseline_single_bed_1_48dp));
        }
        else if(s.equals("2")){
            im.setBackground(getDrawable(R.drawable.baseline_single_bed_2_48dp));
        }
    }
    public void ImageButtonClick(final String key, final ImageButton im){
        im.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reference.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if( dataSnapshot.child(key).getValue().toString().equals("0")){
                            im.setBackground(getDrawable(R.drawable.baseline_single_bed_1_48dp));
                            reference.getRef().child(key).setValue("1");
                            li4.setVisibility(View.VISIBLE); chonghe.setText("Số ghế : ");
                            if(tong > 0) {
                                tong -= Integer.parseInt(dataSnapshot.child("Gia").getValue().toString());
                                tongtien.setText("Tổng tiền : " + tong);

                            }
                            else if(tong == 0)
                                btn_chon.setVisibility(View.INVISIBLE);
                            else
                                tong = 0;
                        }else if(dataSnapshot.child(key).getValue().toString().equals("2")){

                        }
                        else {
                            im.setBackground(getDrawable(R.drawable.baseline_single_bed_black_48dp));
                           tong += Integer.parseInt(dataSnapshot.child("Gia").getValue().toString());
                            reference.getRef().child(key).setValue("0");
                            laysoghe += key;
                            tongtien.setText("Tổng tiền : " + tong);
                            li4.setVisibility(View.VISIBLE); chonghe.setText("Số ghế : " + laysoghe);btn_chon.setVisibility(View.VISIBLE);
                        }
                    }
                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }

        });
    }
    public void AnhXaClick(){
        ImageButtonClick("a1", a1);
        ImageButtonClick("a2", a2);
        ImageButtonClick("a3", a3);
        ImageButtonClick("a4", a4);
        ImageButtonClick("a5", a5);
        ImageButtonClick("a6", a6);
        ImageButtonClick("a7", a7);
        ImageButtonClick("a8", a8);
        ImageButtonClick("a9", a9);
        ImageButtonClick("a10", a10);
        ImageButtonClick("a11", a11);
        ImageButtonClick("a12", a12);
        ImageButtonClick("b1", b1);
        ImageButtonClick("b2", b2);
        ImageButtonClick("b3", b3);
        ImageButtonClick("b4", b4);
        ImageButtonClick("b5", b5);
        ImageButtonClick("b6", b6);
        ImageButtonClick("b7", b7);
        ImageButtonClick("b8", b8);
        ImageButtonClick("b9", b9);
        ImageButtonClick("b10", b10);
        ImageButtonClick("b11", b11);
        ImageButtonClick("b12", b12);
        ImageButtonClick("c1", c1);
        ImageButtonClick("c2", c2);
        ImageButtonClick("c3", c3);
        ImageButtonClick("c4", c4);
        ImageButtonClick("c5", c5);
        ImageButtonClick("c6", c6);
        ImageButtonClick("c7", c7);
        ImageButtonClick("c8", c8);
        ImageButtonClick("c9", c9);
        ImageButtonClick("c10",c10);
        ImageButtonClick("c11", c11);
        ImageButtonClick("c12", c12);
        ImageButtonClick("d1", d1);
        ImageButtonClick("d2", d2);
        ImageButtonClick("d3", d3);
        ImageButtonClick("d4", d4);

    }

}
