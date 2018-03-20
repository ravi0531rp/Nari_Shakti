package com.example.moksh.loginandregister;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.moksh.BuyActivity;
import com.example.moksh.SellActivity;

public class HumanDevelopment extends AppCompatActivity {
private Button sell;
private Button buy;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_human_development);
        sell = findViewById(R.id.btn_sell);
        buy = findViewById(R.id.btn_buy);

        sell.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
startActivity(new Intent(HumanDevelopment.this, SellActivity.class));
            }
        });

        buy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HumanDevelopment.this, BuyActivity.class));

            }
        });
    }
}
