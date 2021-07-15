package com.example.rossytherapy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class AuthActivity extends AppCompatActivity {
    Button mButton;
    EditText mEdit;
    TextView mText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_auth);
        mButton = (Button)findViewById(R.id.sign_in_btn);

        mButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
//                mEdit   = (EditText)findViewById(R.id.editText1);
//                mText = (TextView)findViewById(R.id.textView1);
//                mText.setText("Welcome "+mEdit.getText().toString()+"!");
            }
        });
    }

    public static class SplashPage extends AppCompatActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_splash_page);
        }
    }
}