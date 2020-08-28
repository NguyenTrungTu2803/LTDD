package com.example.daltdd;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.daltdd.class_arraylist.DiaDiem;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ThongTinKhach extends AppCompatActivity {

    private ImageView backdndk;
    private LinearLayout li3;
    private EditText editsdt, edithoten, editemail;
    private TextView tvthongtin, tongtien, dddon, ddtra, soghe;
    private Button btn_xacnhan;
    private DatabaseReference reference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thong_tin_khach);
        AnhXa();
        reference = FirebaseDatabase.getInstance().getReference("SoGhe40");
        backdndk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        li3.setVisibility(View.INVISIBLE);
        tvthongtin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setVisibilityli3();
            }
        });
        LayIntent();
        btn_xacnhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ThongTinKhach.this, MainActivity.class);
                startActivity(intent);
                reference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        reference.getRef().child("a1").setValue("2");
                        reference.getRef().child("a2").setValue("2");
                        //reference.child("DiaChiDon").setValue(tv);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });
    }
    void AnhXa(){
        edithoten = findViewById(R.id.edithoten);
        editemail = findViewById(R.id.editemail);
        editsdt = findViewById(R.id.editsdt);
        tvthongtin = findViewById(R.id.tvxentt);
        btn_xacnhan = findViewById(R.id.btn_xacnhan);
        li3 = findViewById(R.id.li3);
        backdndk = findViewById(R.id.backdndk);
        dddon = findViewById(R.id.dddon); ddtra = findViewById(R.id.ddtra); soghe = findViewById(R.id.tenxe); tongtien = findViewById(R.id.tongtien);
    }
    void setVisibilityli3(){
        if(li3.getVisibility() == View.INVISIBLE)
            li3.setVisibility(View.VISIBLE);
        else
            li3.setVisibility(View.INVISIBLE);
    }
    public void LayIntent(){
        DiaDiem diaDiem = new DiaDiem();
        //dddon.setText("Điểm đón : " + diaDiem.getDdd());
        //ddtra.setText("Điểm trả : " +diaDiem.getDdtr());
    }
}
