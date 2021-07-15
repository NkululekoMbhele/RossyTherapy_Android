package com.example.rossytherapy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import android.view.View;

import com.example.rossytherapy.ui.login.LoginActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;

public class register extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "EmailPassword";
    private FirebaseAuth mAuth;
    private ImageView appLogo;
    private ProgressBar progressBar;
    private Button register;
    private EditText editName, editLastName, editEmail, editPassword, editCountry, editCity, editZipCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_register);
        mAuth = FirebaseAuth.getInstance();

        register = (Button) findViewById(R.id.register);
        register.setOnClickListener(this);
        // First Name
        editName = findViewById(R.id.first_name);
        // Last Name
        editLastName = findViewById(R.id.last_name);
//        Email
        editEmail = findViewById(R.id.email);
        // Password
        editPassword = findViewById(R.id.password);
        // Country
        editCountry = findViewById(R.id.country);
        //City
        editCity = findViewById(R.id.city);
        // Zip Code
        editZipCode = findViewById(R.id.zip_code);

        progressBar = (ProgressBar) findViewById(R.id.loading);

        appLogo = (ImageView) findViewById(R.id.imageView3);
        appLogo.setOnClickListener(this);


    }
//    @Override
//    public void onStart() {
//        super.onStart();
//        // Check if user is signed in (non-null) and update UI accordingly.
//        FirebaseUser currentUser = mAuth.getCurrentUser();
//        if(currentUser != null){
//            reload();
//        }
//    }
//    private void reload() { }



    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.register:
                registerUser();
                break;
            case R.id.imageView3:
                startActivity(new Intent(this, LoginActivity.class));
                break;
        }
    }

    private void registerUser() {
        String email = editEmail.getText().toString().trim();
        String password = editPassword.getText().toString().trim();
        String firstName = editName.getText().toString().trim();
        String lastName = editLastName.getText().toString().trim();
        String country = editCountry.getText().toString().trim();
        String zipCode = editZipCode.getText().toString().trim();
        String city = editCity.getText().toString().trim();

        if (firstName.isEmpty()) {
            editName.setError("First Name is required");
            editName.requestFocus();
            return;
        }
        if (lastName.isEmpty()) {
            editLastName.setError("Last Name is required");
            editLastName.requestFocus();
            return;
        }
        if (email.isEmpty()) {
            editEmail.setError("Email is required");
            editEmail.requestFocus();
            return;
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            editEmail.setError("Please provide valid email");
            editEmail.requestFocus();
            return;
        }
        if (password.isEmpty()) {
            editPassword.setError("Password is required");
            editPassword.requestFocus();
            return;
        }
        if (password.length() < 6) {
            editPassword.setError("Passwords must be greater than 6 digits");
            editPassword.requestFocus();
            return;
        }
        if (country.isEmpty()) {
            editCountry.setError("Country is required");
            editCountry.requestFocus();
            return;
        }
        if (city.isEmpty()) {
            editCity.setError("City is required");
            editCity.requestFocus();
            return;
        }
        if (zipCode.isEmpty()) {
            editZipCode.setError("Zip Code is required");
            editZipCode.requestFocus();
            return;
        }
        progressBar.setVisibility(View.VISIBLE);
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            User user = new User(firstName, lastName, email, password, country, city, zipCode);
                            Toast.makeText(register.this, "User authentication initiated!", Toast.LENGTH_LONG).show();
                            FirebaseDatabase.getInstance().getReference("Users")
                                    .child(mAuth.getCurrentUser().getUid())
                                    .setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (task.isSuccessful()){
                                        Toast.makeText(register.this, "User has been registered successfully!", Toast.LENGTH_LONG).show();
                                        progressBar.setVisibility(View.VISIBLE);

                                        updateUI();

                                    }
                                    else {
                                        Toast.makeText(register.this, "Database Registeration failed!", Toast.LENGTH_LONG).show();
                                        progressBar.setVisibility(View.GONE);
                                    }
                                }
                            });
                        }else{
                            Toast.makeText(register.this, "Auth Registeration failed!", Toast.LENGTH_LONG).show();
                            progressBar.setVisibility(View.GONE);
                        }
                    }
                } );





    }

    private void updateUI() {
        progressBar.setVisibility(View.GONE);
        startActivity(new Intent(this, HomePage.class));
    }
}