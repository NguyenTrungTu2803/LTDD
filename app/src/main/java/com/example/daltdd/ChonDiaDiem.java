package com.example.daltdd;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.Window;
import android.app.Activity;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.daltdd.fragment.diadiemdon;
import com.example.daltdd.fragment.diadiemtra;
import com.google.android.material.bottomnavigation.BottomNavigationView;


public class ChonDiaDiem extends AppCompatActivity {
    diadiemdon diadiemdon = new diadiemdon();
    diadiemtra diadiemtra = new diadiemtra();
    public String tongtien;
    public String soghe, ddd, ddr;
    private BottomNavigationView bottom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_chon_dia_diem);
        AnhXa();
        ClickButtom();
        tongtien = getIntent().getStringExtra("tongtien");
        soghe = getIntent().getStringExtra("ghechon");
        Toast.makeText(this, soghe, Toast.LENGTH_SHORT).show();
    }
    void AnhXa(){
        bottom = findViewById((R.id.menu_dd));

    }
    void ClickButtom(){
        setFrameLayout(diadiemdon);
        final Bundle bundle = new Bundle();

        diadiemdon.setArguments(bundle);
        bottom.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                    switch (menuItem.getItemId()){
                        case R.id.nav_diemdon: {
                            setFrameLayout(diadiemdon);
                            bundle.putString("ghechon", soghe);
                           // Toast.makeText(ChonDiaDiem.this, soghe, Toast.LENGTH_SHORT).show();
                            return true;
                        }
                        case R.id.nav_diemtra:
                            diadiemtra.setArguments(bundle);
                            bundle.putString("ghechon", soghe);
                            //Toast.makeText(ChonDiaDiem.this, soghe, Toast.LENGTH_SHORT).show();
                            setFrameLayout(diadiemtra);
                            return true;
                            default:return false;
                    }

            }
        });
    }
    public void setFrameLayout(Fragment frame){
        FragmentTransaction fragmentTransaction  = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fr_didiem, frame );
        fragmentTransaction.commit();
    }
}
