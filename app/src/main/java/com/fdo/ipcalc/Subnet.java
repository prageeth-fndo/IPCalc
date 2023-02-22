package com.fdo.ipcalc;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class Subnet extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subnet);

        final Button btn = findViewById(R.id.btn);
        final EditText tb1 = findViewById(R.id.tb1);
        final EditText tb2 = findViewById(R.id.tb2);
        final EditText tb3 = findViewById(R.id.tb3);
        final EditText tb4 = findViewById(R.id.tb4);
        final EditText tb5 = findViewById(R.id.tb5);
        final EditText tb6 = findViewById(R.id.tb6);
        final EditText tb7 = findViewById(R.id.tb7);

        tb1.requestFocus();

        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                if (tb1.getText().toString().equals("") || tb2.getText().toString().equals("") || tb3.getText().toString().equals("") || tb4.getText().toString().equals("")
                        || tb5.getText().toString().equals("") || tb6.getText().toString().equals("") || tb7.getText().toString().equals("")) {
                    Toast.makeText(getApplicationContext(), "No Blanks Allowed", Toast.LENGTH_SHORT).show();
                } else {
                    int cidr = Integer.parseInt(tb5.getText().toString());
                    int oct1 = Integer.parseInt(tb1.getText().toString());
                    int oct2 = Integer.parseInt(tb2.getText().toString());
                    int oct3 = Integer.parseInt(tb3.getText().toString());
                    int oct4 = Integer.parseInt(tb4.getText().toString());
                    int noSubs = Integer.parseInt(tb6.getText().toString());
                    int noHosts = Integer.parseInt(tb7.getText().toString());
                    int noOfSubnetBits = 0;
                    ArrayList<String> subnetList = new ArrayList<String>();
                    int hBits = 0, newCidr = 0, subInc = 0, counter = 0;
                    String subnetMask = "", wildcardMask = "", ip = "";

                    if (oct1 > 255 || oct2 > 255 || oct3 > 255 || oct4 > 255) {
                        Toast.makeText(getApplicationContext(), "Invalid IP Address", Toast.LENGTH_SHORT).show();
                    } else if (oct1 < 0 || oct2 < 0 || oct3 < 0 || oct4 < 0) {
                        Toast.makeText(getApplicationContext(), "Invalid IP Address", Toast.LENGTH_SHORT).show();
                    } else if (cidr > 32 || cidr < 0) {
                        Toast.makeText(getApplicationContext(), "Invalid CIDR value", Toast.LENGTH_SHORT).show();
                    } else {
                        try {
                            if (noHosts < 3) {
                                hBits = 2;
                                subInc = 4;
                            } else if (noHosts < 7) {
                                hBits = 3;
                                subInc = 8;
                            } else if (noHosts < 15) {
                                hBits = 4;
                                subInc = 16;
                            } else if (noHosts < 31) {
                                hBits = 5;
                                subInc = 32;
                            } else if (noHosts < 63) {
                                hBits = 6;
                                subInc = 64;
                            } else if (noHosts < 127) {
                                hBits = 7;
                                subInc = 128;
                            } else if (noHosts < 255) {
                                hBits = 8;
                                subInc = 1;
                            } else if (noHosts < 511) {
                                hBits = 9;
                                subInc = 2;
                            } else if (noHosts < 1023) {
                                hBits = 10;
                                subInc = 4;
                            } else if (noHosts < 2047) {
                                hBits = 11;
                                subInc = 8;
                            } else if (noHosts < 4095) {
                                hBits = 12;
                                subInc = 16;
                            } else if (noHosts < 8191) {
                                hBits = 13;
                                subInc = 32;
                            } else if (noHosts < 16383) {
                                hBits = 14;
                                subInc = 64;
                            } else if (noHosts < 32767) {
                                hBits = 15;
                                subInc = 128;
                            } else if (noHosts < 65535) {
                                hBits = 16;
                                subInc = 1;
                            }

                            noOfSubnetBits = (32 - cidr - hBits);
                            ip = oct1 + "." + oct2 + "." + oct3 + "." + oct4 + "/" + cidr;
                            newCidr = 32 - hBits;

                            //subnet increments after bit checking
                            if (noSubs <= Math.pow(2,(32 - cidr - hBits))) {
                                if (newCidr > 23) {
                                    while (counter < noSubs) {
                                        subnetList.add(oct1 + "." + oct2 + "." + oct3 + "." + oct4);
                                        oct4 += subInc;
                                        counter++;

                                        if(oct4 > 255){
                                            oct3 += 1;
                                            oct4 = 0;
                                        }

                                    }

                                } else if (newCidr > 15) {
                                    while (counter < noSubs) {
                                        subnetList.add(oct1 + "." + oct2 + "." + oct3 + "." + oct4);
                                        oct3 += subInc;
                                        counter++;

                                        if(oct3 > 255){
                                            oct2 += 1;
                                            oct4 = oct3 = 0;
                                        }
                                    }

                                } else if (newCidr > 7) {
                                    while (counter < noSubs) {
                                        subnetList.add(oct1 + "." + oct2 + "." + oct3 + "." + oct4);
                                        oct2 += subInc;
                                        counter += 1;
                                    }
                                }

                                switch (newCidr) {
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
                                //progress bar &toast
                                final ProgressDialog pd;
                                pd = ProgressDialog.show(Subnet.this, "Calculating", "Please wait...",true, false);
                                pd.show();
                                new CountDownTimer(3000, 1000) {
                                    @Override
                                    public void onTick(long millisUntilFinished) {
                                        int progress = 3;
                                        pd.setProgress(progress);
                                    }

                                    @Override
                                    public void onFinish() {
                                        //the progressBar will be invisible after 60 000 miliseconds ( 1 minute)
                                        pd.dismiss();
                                    }

                                }.start();

                                //passing data
                                Intent intent = new Intent(Subnet.this, Subnet2.class);
                                intent.putExtra("key1", ip);
                                intent.putExtra("key2", subnetMask);
                                intent.putExtra("key3", wildcardMask);
                                intent.putExtra("key4", noOfSubnetBits+"");
                                intent.putExtra("key5", hBits+"");
                                intent.putExtra("key6", subnetList);
                                startActivity(intent);
                            }
                            else{
                                Toast.makeText(getApplicationContext(), "IP Block is not enough", Toast.LENGTH_SHORT).show();
                            }
                        } catch (Exception e) {
                            Toast.makeText(getApplicationContext(), "Unexpected error" + e, Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            }
        }

        );
    }
}