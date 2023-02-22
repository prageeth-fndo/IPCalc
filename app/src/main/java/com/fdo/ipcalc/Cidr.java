package com.fdo.ipcalc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Cidr extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cidr);

        final Button btn = findViewById(R.id.btn);
        final TextView t1 = findViewById(R.id.t1);
        final TextView t2 = findViewById(R.id.t2);
        final TextView t3 = findViewById(R.id.t3);
        final TextView t4 = findViewById(R.id.t4);
        final TextView t5 = findViewById(R.id.t5);
        final EditText tb1 = findViewById(R.id.tb1);
        final EditText tb2 = findViewById(R.id.tb2);
        final EditText tb3 = findViewById(R.id.tb3);
        final EditText tb4 = findViewById(R.id.tb4);
        final EditText tb5 = findViewById(R.id.tb5);

        tb1.requestFocus();
        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (tb1.getText().toString().equals("") || tb2.getText().toString().equals("") || tb3.getText().toString().equals("") || tb4.getText().toString().equals("") || tb5.getText().toString().equals("")) {
                    Toast.makeText(getApplicationContext(), "No Blanks Allowed", Toast.LENGTH_SHORT).show();
                } else {
                    int cidr = Integer.parseInt(tb5.getText().toString());
                    int oct1 = Integer.parseInt(tb1.getText().toString());
                    int oct2 = Integer.parseInt(tb2.getText().toString());
                    int oct3 = Integer.parseInt(tb3.getText().toString());
                    int oct4 = Integer.parseInt(tb4.getText().toString());
                    String subnetMask = "", wildcardMask = "";

                    if (oct1 > 255 || oct2 > 255 || oct3 > 255 || oct4 > 255) {
                        Toast.makeText(getApplicationContext(), "Invalid IP Address", Toast.LENGTH_SHORT).show();
                    } else if (oct1 < 0 || oct2 < 0 || oct3 < 0 || oct4 < 0) {
                        Toast.makeText(getApplicationContext(), "Invalid IP Address", Toast.LENGTH_SHORT).show();
                    } else if (cidr > 32 || cidr < 0) {
                        Toast.makeText(getApplicationContext(), "Invalid CIDR value", Toast.LENGTH_SHORT).show();
                    } else {
                        try {
                            //subnetmask
                            switch (cidr) {
                                case 0:
                                    subnetMask = "0.0.0.0";
                                    wildcardMask = "255.255.255.255";
                                    break;
                                case 1:
                                    subnetMask = "128.0.0.0";
                                    wildcardMask = "127.255.255.255";
                                    break;
                                case 2:
                                    subnetMask = "192.0.0.0";
                                    wildcardMask = "63.255.255.255";
                                    break;
                                case 3:
                                    subnetMask = "224.0.0.0";
                                    wildcardMask = "31.255.255.255";
                                    break;
                                case 4:
                                    subnetMask = "240.0.0.0";
                                    wildcardMask = "15.255.255.255";
                                    break;
                                case 5:
                                    subnetMask = "248.0.0.0";
                                    wildcardMask = "7.255.255.255";
                                    break;
                                case 6:
                                    subnetMask = "252.0.0.0";
                                    wildcardMask = "3.255.255.255";
                                    break;
                                case 7:
                                    subnetMask = "254.0.0.0";
                                    wildcardMask = "1.255.255.255";
                                    break;
                                case 8:
                                    subnetMask = "255.0.0.0";
                                    wildcardMask = "0.255.255.255";
                                    break;
                                case 9:
                                    subnetMask = "255.128.0.0";
                                    wildcardMask = "0.127.255.255";
                                    break;
                                case 10:
                                    subnetMask = "255.192.0.0";
                                    wildcardMask = "0.63.255.255";
                                    break;
                                case 11:
                                    subnetMask = "255.224.0.0";
                                    wildcardMask = "0.31.255.255";
                                    break;
                                case 12:
                                    subnetMask = "255.240.0.0";
                                    wildcardMask = "0.15.255.255";
                                    break;
                                case 13:
                                    subnetMask = "255.248.0.0";
                                    wildcardMask = "0.7.255.255";
                                    break;
                                case 14:
                                    subnetMask = "255.252.0.0";
                                    wildcardMask = "0.3.255.255";
                                    break;
                                case 15:
                                    subnetMask = "255.254.0.0";
                                    wildcardMask = "0.1.255.255";
                                    break;
                                case 16:
                                    subnetMask = "255.255.0.0";
                                    wildcardMask = "0.0.255.255";
                                    break;
                                case 17:
                                    subnetMask = "255.255.128.0";
                                    wildcardMask = "0.0.127.255";
                                    break;
                                case 18:
                                    subnetMask = "255.255.192.0";
                                    wildcardMask = "0.0.63.255";
                                    break;
                                case 19:
                                    subnetMask = "255.255.224.0";
                                    wildcardMask = "0.0.31.255";
                                    break;
                                case 20:
                                    subnetMask = "255.255.240.0";
                                    wildcardMask = "0.0.15.255";
                                    break;
                                case 21:
                                    subnetMask = "255.255.248.0";
                                    wildcardMask = "0.0.7.255";
                                    break;
                                case 22:
                                    subnetMask = "255.255.252.0";
                                    wildcardMask = "0.0.3.255";
                                    break;
                                case 23:
                                    subnetMask = "255.255.254.0";
                                    wildcardMask = "0.0.1.255";
                                    break;
                                case 24:
                                    subnetMask = "255.255.255.0";
                                    wildcardMask = "0.0.0.255";
                                    break;
                                case 25:
                                    subnetMask = "255.255.255.128";
                                    wildcardMask = "0.0.0.127";
                                    break;
                                case 26:
                                    subnetMask = "255.255.255.192";
                                    wildcardMask = "0.0.0.63";
                                    break;
                                case 27:
                                    subnetMask = "255.255.255.224";
                                    wildcardMask = "0.0.0.31";
                                    break;
                                case 28:
                                    subnetMask = "255.255.255.240";
                                    wildcardMask = "0.0.0.15";
                                    break;
                                case 29:
                                    subnetMask = "255.255.255.248";
                                    wildcardMask = "0.0.0.7";
                                    break;
                                case 30:
                                    subnetMask = "255.255.255.252";
                                    wildcardMask = "0.0.0.3";
                                    break;
                                case 31:
                                    subnetMask = "255.255.255.254";
                                    wildcardMask = "0.0.0.1";
                                    break;
                                case 32:
                                    subnetMask = "255.255.255.255";
                                    wildcardMask = "0.0.0.0";
                                    break;
                            }
                            t1.setText(subnetMask);
                            t2.setText(wildcardMask);

                            //network address

                            int soct1, soct2, soct3, soct4, woct1, woct2, woct3, woct4;
                            int noct1, noct2, noct3, noct4;

                            soct1 = Integer.parseInt(subnetMask.split("\\.")[0]);
                            soct2 = Integer.parseInt(subnetMask.split("\\.")[1]);
                            soct3 = Integer.parseInt(subnetMask.split("\\.")[2]);
                            soct4 = Integer.parseInt(subnetMask.split("\\.")[3]);

                            noct1 = soct1 & oct1;
                            noct2 = soct2 & oct2;
                            noct3 = soct3 & oct3;
                            noct4 = soct4 & oct4;

                            t3.setText(noct1 + "." + noct2 + "." + noct3 + "." + noct4);

                            // broadcast address
                            int boct1, boct2, boct3, boct4;

                            woct1 = Integer.parseInt(wildcardMask.split("\\.")[0]);
                            woct2 = Integer.parseInt(wildcardMask.split("\\.")[1]);
                            woct3 = Integer.parseInt(wildcardMask.split("\\.")[2]);
                            woct4 = Integer.parseInt(wildcardMask.split("\\.")[3]);

                            boct1 = woct1 | oct1;
                            boct2 = woct2 | oct2;
                            boct3 = woct3 | oct3;
                            boct4 = woct4 | oct4;

                            t4.setText(boct1 + "." + boct2 + "." + boct3 + "." + boct4);

                            double hosts = Math.pow(2, (32 - cidr)) - 2;
                            t5.setText((int) hosts + "");

                        } catch (Exception e) {
                            Toast.makeText(getApplicationContext(), "Unexpected error"+e, Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            }
        });
    }
}