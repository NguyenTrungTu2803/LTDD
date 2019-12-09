package com.example.daltdd;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.daltdd.class_Firebaes.DSThongTinXe;
import com.example.daltdd.class_arraylist.arraylistview;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class thongtintimve extends Activity {

    private TextView gio, ngay, tenxe, soghe,gia, benxe;
    private ImageButton imback, imnext;
    private ImageView imbac;
    private DSThongTinXe dsThongTinXe;
    arraylistview arraylv;
    private ListView lv;
    private ArrayList<DSThongTinXe> ds;
    private DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_thongtintimve);
        AnhXa();
        Loadthongtinxe();
        onclickLV();
        imbac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }
    void AnhXa(){
        reference = FirebaseDatabase.getInstance().getReference();
        imbac = findViewById(R.id.back);
        imback = findViewById(R.id.backbtn);
        imnext = findViewById(R.id.nextbtn);
        gio = findViewById(R.id.gio);
        gia = findViewById(R.id.gia);
        ngay = findViewById(R.id.ngay1);
        soghe = findViewById(R.id.soghe);
        tenxe = findViewById(R.id.tenxe);
        benxe = findViewById(R.id.benxe);
        lv = findViewById(R.id.listview);
        ds = new ArrayList<DSThongTinXe>();

    }
    public void Loadthongtinxe(){
        reference.child("PhuongTrang").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                dsThongTinXe = new DSThongTinXe();
                dsThongTinXe.BenXe = dataSnapshot.child("BenXe").getValue().toString();
                    dsThongTinXe.Ngay = dataSnapshot.child("Ngay").getValue().toString();
                    dsThongTinXe.Gio = dataSnapshot.child("Gio").getValue().toString();
                    dsThongTinXe.Gia = dataSnapshot.child("Gia").getValue().toString();
                    dsThongTinXe.SoGhe = dataSnapshot.child("SoGhe").getValue().toString();
                    dsThongTinXe.TeXe = dataSnapshot.child("TenXe").getValue().toString();
                    ds.add(dsThongTinXe);
                arraylv = new arraylistview(thongtintimve.this, ds);
                lv.setAdapter(arraylv);
                arraylv.notifyDataSetChanged();

            }
            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                dsThongTinXe = new DSThongTinXe();
                dsThongTinXe.BenXe = dataSnapshot.child("BenXe").getValue().toString();
                dsThongTinXe.Ngay = dataSnapshot.child("Ngay").getValue().toString();
                dsThongTinXe.Gio = dataSnapshot.child("Gio").getValue().toString();
                dsThongTinXe.Gia = dataSnapshot.child("Gia").getValue().toString();
                dsThongTinXe.SoGhe = dataSnapshot.child("SoGhe").getValue().toString();
                dsThongTinXe.TeXe = dataSnapshot.child("TenXe").getValue().toString();
                ds.add(dsThongTinXe);
                arraylv = new arraylistview(thongtintimve.this, ds);
                lv.setAdapter(arraylv);
                arraylv.notifyDataSetChanged();

            }
            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

            }
            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
    public void onclickLV(){
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(thongtintimve.this, position+ "eeee", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(thongtintimve.this, chon_cho_ngoi.class);
                startActivity(intent);
            }
        });
    }
}
