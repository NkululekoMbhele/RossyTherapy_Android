package com.example.rossytherapy.ui.login;

import android.app.Activity;


import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.rossytherapy.HomePage;
import com.example.rossytherapy.MainActivity2;
import com.example.rossytherapy.R;
import com.example.rossytherapy.register;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "EmailPassword";
    private Button switchToRegisterActivity;
    private Button userLogin;
    private FirebaseAuth mAuth;
    private ImageView appLogo;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_login);
        mAuth = FirebaseAuth.getInstance();
        appLogo = (ImageView) findViewById(R.id.imageView3);
        appLogo.setOnClickListener(this);

        final Button loginButton = findViewById(R.id.login);
        final ProgressBar loadingProgressBar = findViewById(R.id.loading);
        // switch to register
        switchToRegisterActivity = (Button) findViewById(R.id.btn_register);
        switchToRegisterActivity.setOnClickListener(this);

        userLogin = (Button) findViewById(R.id.login);
        userLogin.setOnClickListener(this);

     }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.imageView3:
                startActivity(new Intent(this, LoginActivity.class));
                break;
            case R.id.btn_register:
                startActivity(new Intent(this, register.class));
                break;
            case R.id.login:
                userLogin();
                break;
        }
    }

    private void userLogin() {
    }
}