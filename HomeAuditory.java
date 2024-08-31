package com.example.digitaluniver;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class HomeAuditory extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homeauditory);
    }

    public void startphone1(View view) {
        Intent intent = new Intent(this, Image1.class);
        startActivity(intent);
    }

    public void startxub(View view) {
        Intent intent = new Intent(this, Image2.class);
        startActivity(intent);
    }

    public void actzal(View view) {
        Intent intent = new Intent(this, Image3.class);
        startActivity(intent);
    }

    public void startlibrary(View view) {
        Intent intent = new Intent(this, Image4.class);
        startActivity(intent);
    }

    public void startad(View view) {
        Intent intent = new Intent(this, Image5.class);
        startActivity(intent);
    }
}