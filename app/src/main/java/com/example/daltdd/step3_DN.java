package com.example.daltdd;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.daltdd.class_DN.class_NguoiDung;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class step3_DN extends Activity {

    private ImageView im1;
    private EditText editname;
    private FloatingActionButton floatname;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_step3__dn);
        AnhXa();
        editname.setText(getIntent().getStringExtra("phonenumber"));
        im1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        floatname.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(editname.length()<= 0){
                    editname.setError(getString(R.string.saiten)); editname.findFocus(); return;
                }else{

                    Intent intent = new Intent(step3_DN.this, step4_DN.class);
                    String sdt = getIntent().getStringExtra("sdt");
                    intent.putExtra("sdt", sdt);
                    intent.putExtra("name", editname.getText().toString());
                    startActivity(intent);
                }
            }
        });
    }
    void AnhXa(){
        im1 = findViewById(R.id.backdndk);
        editname = findViewById(R.id.editname);
        floatname = findViewById(R.id.floatmane);
    }
}
