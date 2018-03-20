package com.example.moksh.loginandregister;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.moksh.JoinCamp;
import com.example.moksh.OrganizeCamp;

public class CampingActivities extends AppCompatActivity {
   Button joinCamp;
   Button organizeCamp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camping_activities);

        joinCamp = (Button) findViewById(R.id.join_a_camp);
        joinCamp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CampingActivities.this, JoinCamp.class));

            }
        });

        organizeCamp = (Button) findViewById(R.id.organize_a_camp);
        organizeCamp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CampingActivities.this, OrganizeCamp.class));

            }
        });




    }
}
