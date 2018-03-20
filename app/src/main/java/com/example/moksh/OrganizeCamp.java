package com.example.moksh;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.moksh.loginandregister.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class OrganizeCamp extends AppCompatActivity {
    private EditText organizerName, eventName, mobNo, description;
    private Button organize;
    private  String oName,eName,mNo, des;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_organize_camp);
        organizerName = findViewById(R.id.etOrganizerName);
        eventName = findViewById(R.id.etEventName);
        mobNo = findViewById(R.id.etMobNo);
        description = findViewById(R.id.etDescription);
        organize = findViewById(R.id.btnOrganize);

        organize.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendCampData();
                Toast.makeText(OrganizeCamp.this, "Events details successfully taken", Toast.LENGTH_SHORT).show();
                finish();
            }
        });


    }

    private void sendCampData(){

        oName = organizerName.getText().toString();
        eName = eventName.getText().toString();
        mNo = mobNo.getText().toString();
        des = description.getText().toString();

        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        DatabaseReference myRef = firebaseDatabase.getReference("camps");
        String id= myRef.push().getKey();

        camps camp =new camps(id,oName, eName, mNo, des);
        myRef.child(id).setValue(camp);

    }
}
