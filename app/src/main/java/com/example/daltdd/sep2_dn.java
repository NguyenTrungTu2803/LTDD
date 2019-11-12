package com.example.daltdd;

import androidx.annotation.NonNull;


import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskExecutors;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.concurrent.TimeUnit;

public class sep2_dn extends Activity {

    private FirebaseAuth mAuth;

    private EditText editcode;
    private TextView tex1, view;


    private String LayCode;
    private String mVerificationId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_sep2_dn);
        view = findViewById(R.id.sdtvn);
        tex1 = findViewById(R.id.quaylai);
        editcode = findViewById(R.id.code);
        String s = getIntent().getStringExtra("phoneNumber");
        view.setText(s);
        send(s);
        Click();
        tex1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

    }
    private void send(String number){
        PhoneAuthProvider.getInstance().verifyPhoneNumber(number, 60,TimeUnit.SECONDS,TaskExecutors.MAIN_THREAD, mCallbacks);
    }
    private PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallbacks = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {

        @Override
        public void onCodeSent(@NonNull String s, @NonNull PhoneAuthProvider.ForceResendingToken forceResendingToken) {
            super.onCodeSent(s, forceResendingToken);
            if(s == null)
            mVerificationId = s;
        }

        @Override
        public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {
            String code = phoneAuthCredential.getSmsCode();
            LayCode = code;
            if(code != null){
                editcode.setText(code);
                verifiCode(code);
            }
        }

        @Override
        public void onVerificationFailed(@NonNull FirebaseException e) {
            Toast.makeText(sep2_dn.this, e.getMessage(), Toast.LENGTH_LONG).show();
        }
    };
    private void verifiCode(String code){
        PhoneAuthCredential credential = PhoneAuthProvider.getCredential(mVerificationId, code);
        signInWithCredential(credential);
    }
    private void signInWithCredential(PhoneAuthCredential credential) {
        mAuth.signInWithCredential(credential).addOnCompleteListener(sep2_dn.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Intent intent = new Intent(sep2_dn.this, step3_DN.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intent);
                } else {
                    Toast.makeText(sep2_dn.this, task.getException().getMessage(), Toast.LENGTH_LONG).show();
                }
            }
        });
    }
    private void Click(){
        findViewById(R.id.next).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String code = editcode.getText().toString().trim();
                if(code.isEmpty() || code.length() < 6 || code.length() > 6){
                    editcode.setError("Mã không đúng");
                    editcode.requestFocus(); return;
                }
                if(LayCode == null){
                    editcode.setError("mã không đúngiiii");
                    editcode.requestFocus(); return;
                }
                else{
                    verifiCode(code);
                }
            }
        });
    }

}
