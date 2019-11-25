package com.example.daltdd;




import com.example.daltdd.class_DN.class_NguoiDung;
import com.google.firebase.auth.FirebaseAuth;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class sep2_dn extends Activity {

    private TextView tex1;
    private Spinner spinner;
    private EditText editText;


    private String mVerificationId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_sep2_dn);



        tex1 = findViewById(R.id.quaylai);
        spinner = findViewById(R.id.spinnerCountries);
        spinner.setAdapter(new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, CountryData.countryNames));
        editText = findViewById(R.id.editTextPhone);
        findViewById(R.id.buttonContinue).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String code = CountryData.countryAreaCodes[spinner.getSelectedItemPosition()];
                String number = editText.getText().toString().trim();
                if(number.isEmpty()){
                    editText.setError("Không nên để trống");
                    editText.requestFocus(); return;
                }
                if(code == "84") {
                   if(number.length() == 10) {
                        if (number.charAt(0) == '0') {
                            String phonenumber = "+" + code + number;
                            Intent intent = new Intent(sep2_dn.this, VerifyPhoneActivity.class);
                            intent.putExtra("phonenumber", phonenumber);
                            startActivity(intent);
                       } else {
                            editText.setError("số điện thoại không hợp lệ");
                           editText.requestFocus();
                           return;
                        }
                    }
               }
            }
        });
        tex1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

    }

    /*@Override
    protected void onStart() {
        super.onStart();
        if(FirebaseAuth.getInstance().getCurrentUser() != null){
            Intent intent = new Intent(sep2_dn.this, DKDN.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
        }
    }*/
}
