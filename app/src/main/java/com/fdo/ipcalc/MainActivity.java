package com.fdo.ipcalc;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ImageView btn = findViewById(R.id.btn);
        final RadioButton rb1 = findViewById(R.id.rb1);
        final RadioButton rb2 = findViewById(R.id.rb2);
        final RadioButton rb3 = findViewById(R.id.rb3);

        rb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rb2.setChecked(false);
                rb3.setChecked(false);
            }
        });

        rb2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rb1.setChecked(false);
                rb3.setChecked(false);
            }
        });

        rb3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rb2.setChecked(false);
                rb1.setChecked(false);
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (rb1.isChecked()) {
                    startActivity(new Intent(MainActivity.this, Classful.class));
                } else if (rb2.isChecked()) {
                    startActivity(new Intent(MainActivity.this, Cidr.class));
                } else if (rb3.isChecked()) {
                    startActivity(new Intent(MainActivity.this, Subnet.class));
                } else {
                    Toast.makeText(getApplicationContext(), "Please select an Option", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    //double press back
    boolean doubleBackToExitPressedOnce = false;
    @Override
    public void onBackPressed() {

            if (doubleBackToExitPressedOnce) {
                super.onBackPressed();
                return;
            }

            this.doubleBackToExitPressedOnce = true;
            Toast.makeText(this, "Press back button again to exit", Toast.LENGTH_SHORT).show();

            new Handler().postDelayed(new Runnable() {

                @Override
                public void run() {
                    doubleBackToExitPressedOnce=false;
                }
            }, 2000);

    }
}