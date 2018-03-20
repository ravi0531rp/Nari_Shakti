package com.example.moksh.loginandregister;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {
    private EditText MobileNo;
    private EditText Password;
    private Button Login;
    private TextView UserRegistration;
    private FirebaseAuth firebaseAuth;
    private ProgressDialog progressDialog;
    private TextView forgotPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MobileNo = (EditText) findViewById(R.id.etMobileNo);
        Password = (EditText) findViewById(R.id.etPassword);
        Login = (Button) findViewById(R.id.btnLogin);
        UserRegistration = (TextView) findViewById(R.id.tvRegister);
        forgotPassword = (TextView)findViewById(R.id.tvForgotPassword);

        firebaseAuth = FirebaseAuth.getInstance();
        progressDialog = new ProgressDialog(this);

        //This block of code checks if the user is already logged in. If yes then he is prompted to second activity.
        FirebaseUser user = firebaseAuth.getCurrentUser();
        if(user!=null){
            finish();
            startActivity(new Intent(MainActivity.this, SecondActivity.class));
        }

       Login.setOnClickListener(new View.OnClickListener() {
            @Override
           public void onClick(View view) {
                if(MobileNo.getText().toString().isEmpty() || Password.getText().toString().isEmpty())
                {
                    Toast.makeText(MainActivity.this, "enter your email and password to login", Toast.LENGTH_SHORT).show();
                }else{
                validate(MobileNo.getText().toString(),Password.getText().toString());}
            }
        });


         UserRegistration.setOnClickListener(new View.OnClickListener() {
           @Override
            public void onClick(View view) {
               startActivity(new Intent(MainActivity.this, RegistrationActivity.class));
          }
        });

         forgotPassword.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 startActivity(new Intent(MainActivity.this, PasswordActivity.class));
             }
         });
    }

    private void validate(String userMobileNo, String userPassword){
        /*if((userMobileNo.equals("9086031210") ) && (userPassword.equals("1234") )){
            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            startActivity(intent);
        }
        else{
            Toast.makeText(getApplicationContext(),"Mobile No. or Password is incorrect", Toast.LENGTH_SHORT).show();

        }*/

        progressDialog.setMessage("Logging in...");
        progressDialog.show();

        firebaseAuth.signInWithEmailAndPassword(userMobileNo, userPassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    progressDialog.dismiss();
                    checkEmailVerification();
                    //Toast.makeText(MainActivity.this,"Login Successful", Toast.LENGTH_SHORT).show();
                    //startActivity(new Intent(MainActivity.this, SecondActivity.class));
                }
                else{
                    progressDialog.dismiss();
                    Toast.makeText(MainActivity.this,"Login Failed", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    //Function to check if the user has already verified his email or not

    private void checkEmailVerification(){
        FirebaseUser firebaseUser = firebaseAuth.getInstance().getCurrentUser();
        Boolean emailFlag = firebaseUser.isEmailVerified();
        if(emailFlag){
            finish();
            startActivity(new Intent(MainActivity.this, SecondActivity.class));
        }else{
            Toast.makeText(MainActivity.this, "Verify your email", Toast.LENGTH_SHORT).show();
            firebaseAuth.signOut();
        }
    }
}
