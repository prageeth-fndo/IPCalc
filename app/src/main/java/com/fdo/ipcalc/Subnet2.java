package com.fdo.ipcalc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class Subnet2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subnet2);

        final TextView tv = findViewById(R.id.tv);
        final TextView tv1 = findViewById(R.id.tv1);
        final TextView tv2 = findViewById(R.id.tv2);
        final TextView tv3 = findViewById(R.id.tv3);
        final TextView tv4 = findViewById(R.id.tv4);
        final TextView tv5 = findViewById(R.id.tv5);

        String ip="" , subnetMask="", wildCardMask="" , sBits="", hBits="";
        ArrayList<String> subnets = new ArrayList<String>();

        Intent intent = getIntent();
        ip = intent.getStringExtra("key1");
        subnetMask = intent.getStringExtra("key2");
        wildCardMask = intent.getStringExtra("key3");
        sBits = intent.getStringExtra("key4");
        hBits = intent.getStringExtra("key5");
        subnets = intent.getStringArrayListExtra("key6");

        tv.setText(ip);
        tv1.setText(subnetMask);
        tv2.setText(wildCardMask);
        tv3.setText(sBits);
        tv4.setText(hBits);
        for(int i=0; i<subnets.size(); i++){
            tv5.append(subnets.get(i) + System.lineSeparator());
        }
    }
}