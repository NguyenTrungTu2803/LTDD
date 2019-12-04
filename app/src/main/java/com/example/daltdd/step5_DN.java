package com.example.daltdd;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class step5_DN extends Activity {

    private EditText editpass;
    private FloatingActionButton floatpass;
    private TextView textView;
    private ImageView im1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_step5__dn);
        AnhXa();
        im1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(textView.getText() == getString(R.string.show) ){
                    textView.setText(R.string.hide);
                    editpass.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                }
                else if(textView.getText() == getString(R.string.hide)){
                    textView.setText(R.string.show);
                    editpass.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
            }
        });
        floatpass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(editpass.length()< 6){
                    Toast.makeText(step5_DN.this, getString(R.string.mkyeu), Toast.LENGTH_LONG).show();
                }
                else{
                    Intent intent = new Intent(step5_DN.this, XacNhanTaoTKActivity.class);
                    String sdt = getIntent().getStringExtra("sdt");
                    String ten = getIntent().getStringExtra("name");
                    String email = getIntent().getStringExtra("email");
                    intent.putExtra("sdt", sdt);
                    intent.putExtra("ten", ten);
                    intent.putExtra("email", email);
                    intent.putExtra("pass", editpass.getText().toString());
                    startActivity(intent);
                }
            }
        });
    }
    void AnhXa(){
        im1 = findViewById(R.id.backdndk);
        editpass = findViewById(R.id.editpass);
        floatpass = findViewById(R.id.floatpass);
        textView = findViewById(R.id.hidepass);
    }

}
