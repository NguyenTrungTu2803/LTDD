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

public class step4_DN extends Activity {

    private EditText editemail;
    private FloatingActionButton floatemail;
    private ImageView im1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_step4__dn);
        AnhXa();
        im1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        floatemail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(editemail.length()<= 0){
                    editemail.setError(getString(R.string.emaildk)); editemail.findFocus(); return;
                }else{
                    Intent intent = new Intent(step4_DN.this, step5_DN.class);
                    String sdt = getIntent().getStringExtra("sdt");
                    String ten = getIntent().getStringExtra("name");
                    intent.putExtra("sdt", sdt);
                    intent.putExtra("ten", ten);
                    intent.putExtra("email", editemail.getText().toString());
                    startActivity(intent);
                }
            }
        });

    }
    void AnhXa(){
        im1 = findViewById(R.id.backdndk);
        editemail = findViewById(R.id.editemail);
        floatemail = findViewById(R.id.floatemail);
    }
}
