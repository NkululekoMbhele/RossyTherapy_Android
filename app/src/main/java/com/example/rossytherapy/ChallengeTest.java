package com.example.rossytherapy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class ChallengeTest extends AppCompatActivity {
    TextView Name;
    TextView Surname;
    TextView Email;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_challenge_test);
    }

    public void onClickRegister(View view) {
        Name = findViewById(R.id.textViewName);
        EditText editName = findViewById(R.id.editTextName);
        Name.setText("Name: " + editName.getText().toString());

        Surname = findViewById(R.id.textViewSurname);
        EditText editSurname = findViewById(R.id.editTextSurname);
        Surname.setText("Surname: " + editSurname.getText().toString());

        Email = findViewById(R.id.textViewEmail);
        EditText editEmail = findViewById(R.id.editTextEmail);
        Email.setText("Email: " + editEmail.getText().toString());
    }


}