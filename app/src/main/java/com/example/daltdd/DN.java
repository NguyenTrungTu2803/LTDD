package com.example.daltdd;


import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.Window;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class DN extends Activity{
    private TextView text1;
    private EditText editsdt;
    private Button btnsms;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_dn);

        editsdt = findViewById(R.id.sdt);
        btnsms = findViewById(R.id.sms);
        text1 = findViewById(R.id.quaylai);

        text1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        LaySDT();
    }
    private void LaySDT(){
        findViewById(R.id.sms).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String number = editsdt.getText().toString().trim();
                if(number.isEmpty()){
                    editsdt.setError("Không để trống sđt");
                    editsdt.requestFocus();return;
                }
                String phoneNumber = "+84" + number;
                Intent intent = new Intent(DN.this, sep2_dn.class);
                intent.putExtra("phoneNumber", phoneNumber);
                startActivity(intent);
            }
        });
    }


}
