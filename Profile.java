package com.example.digitaluniver;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.LinkedList;

public class Profile extends AppCompatActivity {

    TextView userName, userEmail, userPassword;
    Button startTest;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        Intent intent=getIntent();
        String uName=intent.getStringExtra("name");
        String uEmail=intent.getStringExtra("email");
        String uPass=intent.getStringExtra("password");

        userName=findViewById(R.id.userName);
        userEmail=findViewById(R.id.userEmail);
        userPassword=findViewById(R.id.userPassword);

        userName.setText("User name: "+uName);
        userEmail.setText("User email: "+uEmail);
        userPassword.setText("User password: "+uPass);

    }

    public void startbastybet(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }


//    public void startchatbot(View view) {
//        Intent intent = new Intent(this, ChatBot.class);
//        startActivity(intent);
//    }
}