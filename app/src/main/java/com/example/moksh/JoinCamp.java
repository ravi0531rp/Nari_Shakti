package com.example.moksh;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.moksh.loginandregister.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class JoinCamp extends AppCompatActivity {
    public static final String CAMP_ID="Event id";
    public static final String ORG_NAME="Organizer name";
    public static final String CAMP_NAME="EventName";
    public static final String MOB_NO="Mobile No";
    public static final String DESC="Description";

    DatabaseReference databasecamps;
    ListView listViewCamps;
    List<camps> campings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join_camp);
        databasecamps = FirebaseDatabase.getInstance().getReference("camps");
    }

    @Override
    protected void onStart() {
        super.onStart();
        databasecamps.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                campings.clear();
                for(DataSnapshot campSnapshot:dataSnapshot.getChildren()){
                    camps camp=campSnapshot.getValue(camps.class);
                    campings.add(camp);
                }
                CampList adapter = new CampList(JoinCamp.this,campings);
                listViewCamps.setAdapter(adapter);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
