package com.example.daltdd;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.WindowDecorActionBar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;
    private FrameLayout frameLayout;
    private  fram_taikhoan fram_taikhoan = new fram_taikhoan();
    private fram_timve fram_timve = new fram_timve();
    private  fram_vecuatoi fram_vecuatoi = new fram_vecuatoi();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavigationView = findViewById(R.id.main_nav);
        frameLayout = findViewById(R.id.fram_main);
        clickbottom();
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
    void setFrameLayout(Fragment frame){
        FragmentTransaction fragmentTransaction  = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fram_main, frame );
        fragmentTransaction.commit();
    }
    void actionbar()
    {

    }
}
