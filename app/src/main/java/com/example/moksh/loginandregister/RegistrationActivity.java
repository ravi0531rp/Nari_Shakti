package com.example.moksh.loginandregister;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.moksh.UserProfile;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegistrationActivity extends AppCompatActivity {
    private EditText userName, userMobileNo, userPassword,userRePassword;
    private Button regButton;
    private TextView userLogin;
    private EditText userAge;
    private FirebaseAuth firebaseAuth;
    private String name, mobileNo, age;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        setupUIViews();

        firebaseAuth = FirebaseAuth.getInstance();

        regButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(validate()){
                    //Upload data to the database
                    String user_email = userMobileNo.getText().toString().trim();
                    String user_password = userPassword.getText().toString().trim();
                    firebaseAuth.createUserWithEmailAndPassword(user_email, user_password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){
                                sendEmailVerification();
                            //Toast.makeText(RegistrationActivity.this, "Registration Successful", Toast.LENGTH_SHORT).show();
                           // startActivity(new Intent (RegistrationActivity.this, MainActivity.class));
                            }
                            else{
                                Toast.makeText(RegistrationActivity.this, "Registration Failed. Network Error", Toast.LENGTH_SHORT).show();}
                            }

                        });
                }

            }
        });

        userLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RegistrationActivity.this, MainActivity.class));
            }
        });
    }

    private void setupUIViews()
    {
        userName = (EditText) findViewById(R.id.etUserName);
        userMobileNo = (EditText) findViewById(R.id.etUserMobileNo);
        userPassword = (EditText) findViewById(R.id.etUserPassword);
        userAge = (EditText) findViewById(R.id.etUserAge);
        regButton = (Button) findViewById(R.id.btnRegister);
        userLogin = (TextView) findViewById(R.id.tvUserLogin);
        userRePassword = (EditText) findViewById(R.id.etUserRePassword);
    }

    private Boolean validate()
    {
        Boolean result = false;
        name = userName.getText().toString();
        mobileNo = userMobileNo.getText().toString();
        age = userAge.getText().toString();
        String password = userPassword.getText().toString();
        String repassword = userRePassword.getText().toString();

        if(name.isEmpty() || mobileNo.isEmpty() || password.isEmpty() || age.isEmpty())
        {
            Toast.makeText(this, "Please enter all the details", Toast.LENGTH_SHORT).show();
        }



        else{
            if(repassword.equals(password)==false){
                Toast.makeText(this, "Password don't match", Toast.LENGTH_SHORT).show();
            }
            else{
                result = true;}
        }
        return result;
    }
    //Function to send the email verfication
    private void sendEmailVerification(){
        FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();
        if(firebaseUser!= null){
            firebaseUser.sendEmailVerification().addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    if(task.isSuccessful()){
                        sendUserData();
                        Toast.makeText(RegistrationActivity.this, "Successfully Registered. Verification mail sent!", Toast.LENGTH_SHORT).show();
                        firebaseAuth.signOut();
                        finish();
                        startActivity(new Intent(RegistrationActivity.this, MainActivity.class));
                    }else{
                        Toast.makeText(RegistrationActivity.this, "Registration failed. Check your network connection", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

    private void sendUserData(){
        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        DatabaseReference myRef = firebaseDatabase.getReference(firebaseAuth.getUid());
        UserProfile userProfile = new UserProfile(age, mobileNo, name);
        myRef.setValue(userProfile);
    }


}
