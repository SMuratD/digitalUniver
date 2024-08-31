package com.example.digitaluniver;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.digitaluniver.databinding.ActivityTeachersBinding;

public class Teachers extends AppCompatActivity {

    private ActivityTeachersBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityTeachersBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        BottomNavigationView navView = findViewById(R.id.nav_view1);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_teachers);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(binding.navView1, navController);
    }

    public void teacher1(View view) {
        Intent intent = new Intent(this, Teacher1.class);
        startActivity(intent);
    }

    public void teacher2(View view) {
        Intent intent = new Intent(this, Teacher2.class);
        startActivity(intent);
    }

    public void teacher3(View view) {
        Intent intent = new Intent(this, Teacher3.class);
        startActivity(intent);
    }
    public void teacher4(View view) {
        Intent intent = new Intent(this, Teacher4.class);
        startActivity(intent);
    }
}