package com.fdo.ipcalc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Classful extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classful);

        final Button btn = findViewById(R.id.btn);
        final TextView t1 = findViewById(R.id.t1);
        final TextView t2 = findViewById(R.id.t2);
        final TextView t3 = findViewById(R.id.t3);
        final TextView t4 = findViewById(R.id.t4);
        final TextView t5 = findViewById(R.id.t5);
        final TextView t6 = findViewById(R.id.t6);
        final EditText tb1 = findViewById(R.id.tb1);
        final EditText tb2 = findViewById(R.id.tb2);
        final EditText tb3 = findViewById(R.id.tb3);
        final EditText tb4 = findViewById(R.id.tb4);
        tb1.requestFocus();

        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {


                if (tb1.getText().toString().equals("") || tb2.getText().toString().equals("") || tb3.getText().toString().equals("") || tb4.getText().toString().equals("")) {
                    Toast.makeText(getApplicationContext(), "No Blanks Allowed", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    int oct1 = Integer.parseInt(tb1.getText().toString());
                    int oct2 = Integer.parseInt(tb2.getText().toString());
                    int oct3 = Integer.parseInt(tb3.getText().toString());
                    int oct4 = Integer.parseInt(tb4.getText().toString());

                    if (oct1 > 255 || oct2 > 255 || oct3 > 255 || oct4 > 255) {
                        Toast.makeText(getApplicationContext(), "Invalid IP Address", Toast.LENGTH_SHORT).show();
                    }

                    else if (oct1 < 0 || oct2 < 0 || oct3 < 0 || oct4 < 0) {
                        Toast.makeText(getApplicationContext(), "Invalid IP Address", Toast.LENGTH_SHORT).show();
                    }

                    else{
                        try{
                            if(oct1<128){
                                t1.setText("IP Class A");
                                t2.setText("255.0.0.0");
                                t3.setText("0.255.255.255");
                                t4.setText(tb1.getText()+".0.0.0");
                                t5.setText(tb1.getText()+".255.255.255");
                                t6.setText("16,777,214");
                            } else if(oct1<192){
                                t1.setText("IP Class B");
                                t2.setText("255.255.0.0");
                                t3.setText("0.0.255.255");
                                t4.setText(tb1.getText()+"."+tb2.getText()+".0.0");
                                t5.setText(tb1.getText()+"."+tb2.getText()+".255.255");
                                t6.setText("65,534");
                            } else if(oct1<223){
                                t1.setText("IP Class C");
                                t2.setText("255.255.255.0");
                                t3.setText("0.0.0.255");
                                t4.setText(tb1.getText()+"."+tb2.getText()+"."+tb3.getText()+".0");
                                t5.setText(tb1.getText()+"."+tb2.getText()+"."+tb3.getText()+".255");
                                t6.setText("254");
                            } else if(oct1<234){
                                t1.setText("IP Class D");
                                t2.setText(" Unspecified");
                                t3.setText("Unspecified");
                                t4.setText("Unspecified");
                                t5.setText("Unspecified");
                                t6.setText("Unspecified");
                            }   else if(oct1<256){
                                t1.setText("IP Class E");
                                t2.setText("Unspecified");
                                t3.setText("Unspecified");
                                t4.setText("Unspecified");
                                t5.setText("Unspecified");
                                t6.setText("Unspecified");
                            }
                        }
                        catch (Exception e){
                            Toast.makeText(getApplicationContext(), "Unexpected error", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            }
        });
    }
}