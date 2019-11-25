package com.example.daltdd;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;

import com.example.daltdd.class_DN.class_NguoiDung;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class XacNhanTaoTKActivity extends Activity {

    private String  sdt, ten, email, pass;

    private DatabaseReference reference;
    private Button btnyes, btnno;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_xac_nhan_tao_tk);
        AnhXa();
        reference = FirebaseDatabase.getInstance().getReference();
        btnno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(XacNhanTaoTKActivity.this, DKDN.class);
                startActivity(intent);
            }
        });
        btnyes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddAcount();

            }
        });
    }
    void AnhXa(){
        btnno = findViewById(R.id.btn_tuchoi); btnyes= findViewById(R.id.btn_dongy);
        Intent intent = getIntent();
        email = intent.getStringExtra("email");
        sdt = intent.getStringExtra("sdt");
        ten =getIntent().getStringExtra("name");
        pass =getIntent().getStringExtra("pass");
    }
    void AddAcount(){
        if(!TextUtils.isEmpty(ten)||!TextUtils.isEmpty(sdt) || !TextUtils.isEmpty(pass) || !TextUtils.isEmpty(email)){
            class_NguoiDung nguoiDung = new class_NguoiDung(sdt, pass, email, pass);
            reference.child("Acount").push().setValue(nguoiDung);
            Toast.makeText(this, getString(R.string.insertacount),Toast.LENGTH_LONG).show();
        }
       else {
            Toast.makeText(this, getString(R.string.yesfalse), Toast.LENGTH_LONG).show();
        }
    }
}
