package com.example.daltdd;


import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import android.widget.FrameLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;
    private FrameLayout frameLayout, fram1,fram2, fram3, fram4, fram5, fram6, fram7, fram8, fram9;
    public  fram_taikhoan fram_taikhoan = new fram_taikhoan();
    private fram_timve fram_timve = new fram_timve();
    private  fram_vecuatoi fram_vecuatoi = new fram_vecuatoi();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavigationView = findViewById(R.id.main_nav);
        frameLayout = findViewById(R.id.fram_main);
        clickbottom();
        actionbar();
    }

    void clickbottom()
    {
        setFrameLayout(fram_timve);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId())
                {
                    case R.id.nav_timve:
                        bottomNavigationView.setItemBackgroundResource(R.color.colorPrimary);
                        setFrameLayout(fram_timve);
                        return true;
                    case R.id.nav_vecuatoi:
                        bottomNavigationView.setItemBackgroundResource(R.color.colorAccent);
                        setFrameLayout(fram_vecuatoi);
                        return true;
                    case R.id.nav_taikhoan:
                        bottomNavigationView.setItemBackgroundResource(R.color.colorPrimaryDark);
                        setFrameLayout(fram_taikhoan);
                        return true;
                        default:
                            return false;
                }
            }
        });
    }
    public void setFrameLayout(Fragment frame){
        FragmentTransaction fragmentTransaction  = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fram_main, frame );
        fragmentTransaction.commit();
    }
    void actionbar() {
        Drawable drawable= getResources().getDrawable(R.drawable.capture);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setBackgroundDrawable(drawable);
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setLogo(R.drawable.unnamed);    //Icon muốn hiện thị
        actionBar.setDisplayUseLogoEnabled(true);

    }

    @Override
    protected void onStart() {
        super.onStart();
        //setFrameLayout(fram_taikhoan);
    }
}
