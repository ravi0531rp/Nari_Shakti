package com.example.moksh.loginandregister;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class BhamashahYojana extends AppCompatActivity {


private TextView citizenRegistration, citizenEnrollment, citizenForgotRegistration, getCitizenReceipt, citizenDocUpload, getCardStatus, pdfEnroll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bhamashah);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        citizenRegistration = findViewById(R.id.citizen_registration);
        citizenEnrollment = findViewById(R.id.citizen_enrollment);
        citizenForgotRegistration = findViewById(R.id.forgot_registration);
        getCitizenReceipt = findViewById(R.id.get_citizen_receipt);
        citizenDocUpload = findViewById(R.id.citizen_doc_upload);
        getCardStatus = findViewById(R.id.get_card_status);
        pdfEnroll = findViewById(R.id.pdf_enroll);

        citizenRegistration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "http://164.100.222.168:8080/bhamashahmain/citizenRegistration";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });

        citizenEnrollment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "http://164.100.222.168:8080/bhamashahmain/citizenEnrollment";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });

        citizenForgotRegistration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "http://164.100.222.168:8080/bhamashahmain/citizenForgotRegistration";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });

        getCitizenReceipt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "http://164.100.222.168:8080/bhamashahmain/getCitizenReceipt";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });

        citizenDocUpload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "http://164.100.222.168:8080/bhamashahmain/citizenDocUpload";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });

        getCardStatus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "http://164.100.222.168:8080/bhamashahmain/getCardStatus";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });

        pdfEnroll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "http://164.100.222.168:8080/bhamashahmain/pdfEnroll";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });


}
}
