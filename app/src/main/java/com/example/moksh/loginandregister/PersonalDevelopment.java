package com.example.moksh.loginandregister;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

public class PersonalDevelopment extends AppCompatActivity {
    LinearLayout moralValues;
    LinearLayout hygienicBehaviour;
    LinearLayout respectForWomen;
    LinearLayout dignityOfLabour;
    LinearLayout reducingRiskBehaviour;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_development);


        moralValues = (LinearLayout) findViewById(R.id.moral_vlues_id);
        moralValues.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Moral Values", Toast.LENGTH_SHORT).show();
            }
        });
        hygienicBehaviour = (LinearLayout) findViewById(R.id.hygienic_behaviour_id);
        hygienicBehaviour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Hygenic behaviour", Toast.LENGTH_SHORT).show();
            }
        });
        respectForWomen = (LinearLayout) findViewById(R.id.respect_of_women);
        respectForWomen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Respecting the women", Toast.LENGTH_SHORT).show();
            }
        });
        dignityOfLabour = (LinearLayout) findViewById(R.id.dignity_of_labour);
        dignityOfLabour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Dignity Of labour", Toast.LENGTH_SHORT).show();
            }
        });
        reducingRiskBehaviour = (LinearLayout)findViewById(R.id.reduce_risk_behaviour);
        reducingRiskBehaviour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Reducing Risk Behaviour Activities", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
