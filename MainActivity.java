package com.example.digitaluniver;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        super.onCreateOptionsMenu(menu);
//        menu.add("Настройки");
//        menu.add("Открыть");
//        menu.add("Сохранить");
//        return true;
//    }


    public void startNewActivity(MenuItem item) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void startAuditory(MenuItem item){
        Intent intent = new Intent(this, HomeAuditory.class);
        startActivity(intent);
    }

    public void startProfile(MenuItem item){
        Intent intent = new Intent(this, Profile.class);
        startActivity(intent);
    }

    public void startlesson(View view) {
        Intent intent = new Intent(this, LessonList.class);
        startActivity(intent);
    }

    public void steachers(View view) {
        Intent intent = new Intent(this, Teachers.class);
        startActivity(intent);
    }

    public void startdecan(View view) {
        Intent intent = new Intent(this, Decanat.class);
        startActivity(intent);
    }

    public void startrector(View view) {
        Intent intent = new Intent(this, Rectorat.class);
        startActivity(intent);
    }
}