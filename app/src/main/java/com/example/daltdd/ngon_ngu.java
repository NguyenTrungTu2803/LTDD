package com.example.daltdd;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.app.Dialog;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.app.Activity;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.Toast;

import java.util.Locale;

public class ngon_ngu extends Activity {
    private LinearLayout li2;
    private ImageView imback;
    private RadioButton rad1, rad2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_ngon_ngu);
        li2 = findViewById(R.id.li2);

        rad1 = findViewById(R.id.rad1); rad2 = findViewById(R.id.rad2);

        imback = findViewById(R.id.back);
        imback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        li2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog dialog = new Dialog(ngon_ngu.this);
                dialog.setContentView(R.layout.alertdialog);
                dialog.show();
                rad1 = dialog.findViewById(R.id.rad1); rad2 = dialog.findViewById(R.id.rad2);
                //rad1.setChecked(true); rad2.setChecked(false);

                rad1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ganngonngu("vi");
                        rad1.setChecked(true); rad2.setChecked(false);
                    }
                });
                rad2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ganngonngu("en");
                        rad2.setChecked(true); rad1.setChecked(false);
                    }
                });
                dialog.dismiss();
                Toast.makeText(ngon_ngu.this, "Không hiển thị được", Toast.LENGTH_SHORT).show();
            }
        });

    }
    void ganngonngu(String nn)
    {
        Locale locale = new Locale(nn);
        Configuration configuration = new Configuration();
        configuration.locale = locale;
        getBaseContext().getResources().updateConfiguration(configuration, getBaseContext().getResources().getDisplayMetrics());
        Intent intent = new Intent(ngon_ngu.this, MainActivity.class);
        startActivity(intent);
        finish();
    }

}
