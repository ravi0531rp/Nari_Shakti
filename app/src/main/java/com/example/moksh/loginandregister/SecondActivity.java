package com.example.moksh.loginandregister;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.example.moksh.Education;
import com.example.moksh.ProfileActivity;
import com.google.firebase.auth.FirebaseAuth;

public class SecondActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private FirebaseAuth firebaseAuth;
    TextView personal;
    TextView business;
    TextView camps;
    TextView hygiene;
    TextView safety;
    TextView education;
    TextView enrollment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        firebaseAuth = FirebaseAuth.getInstance();
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        /*FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/
        personal = (TextView) findViewById(R.id.personal_id);
        business = (TextView) findViewById(R.id.business_id);
        camps = (TextView) findViewById(R.id.camping);
        hygiene = (TextView) findViewById(R.id.hygiene);
        safety = (TextView) findViewById(R.id.safety_tips_id);
        education = (TextView) findViewById(R.id.literacy_id);
        enrollment = (TextView) findViewById(R.id.enrollment_id);


        personal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SecondActivity.this,PersonalDevelopment.class));
            }
        });
        camps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SecondActivity.this,CampingActivities.class));
            }
        });

        enrollment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(SecondActivity.this,BhamashahYojana.class));
                /*
                String url = "https://www.google.co.in";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
                */
            }
        });

        business.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SecondActivity.this, HumanDevelopment.class));
            }
        });

        hygiene.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SecondActivity.this, EnvironmentalDevelopment.class));
            }
        });

        safety.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SecondActivity.this, AgricultureDevelopment.class));
            }
        });

        education.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SecondActivity.this, Education.class));

            }
        });


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.second, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch(item.getItemId()){
            case R.id.action_logout:{
                firebaseAuth.signOut();
                finish();
                startActivity(new Intent(SecondActivity.this, MainActivity.class));
            }

            case R.id.action_profile:{
                startActivity(new Intent(SecondActivity.this, ProfileActivity.class));
            }
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {

            Toast.makeText(getApplicationContext(),"Hii",Toast.LENGTH_SHORT).show();
            startActivity(new Intent(SecondActivity.this, PersonalDevelopment.class));

        } else if (id == R.id.nav_gallery) {

            Toast.makeText(getApplicationContext(),"Hii",Toast.LENGTH_SHORT).show();
            startActivity(new Intent(SecondActivity.this, HumanDevelopment.class));

        } else if (id == R.id.nav_slideshow) {

            Toast.makeText(getApplicationContext(),"Hii",Toast.LENGTH_SHORT).show();
            startActivity(new Intent(SecondActivity.this, AgricultureDevelopment.class));


        } else if (id == R.id.nav_manage) {

            Toast.makeText(getApplicationContext(),"Hii",Toast.LENGTH_SHORT).show();
            startActivity(new Intent(SecondActivity.this, EnvironmentalDevelopment.class));


        } else if (id == R.id.nav_environment) {

            Toast.makeText(getApplicationContext(),"Hii",Toast.LENGTH_SHORT).show();
            startActivity(new Intent(SecondActivity.this, CampingActivities.class));


        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
