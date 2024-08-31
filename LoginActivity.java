package com.example.digitaluniver;

import static com.example.digitaluniver.StoreDatabase.COLUMN_EMAIL;
import static com.example.digitaluniver.StoreDatabase.COLUMN_NAME;
import static com.example.digitaluniver.StoreDatabase.COLUMN_PASSWORD;
import static com.example.digitaluniver.StoreDatabase.TABLE_NAME;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText regis_email, regis_password;
    Button btn_login, btn_tirkelu;
    StoreDatabase storeDatabase;
    SQLiteDatabase sqLiteDatabase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //tildiOzgertu("kk");

        btn_login=findViewById(R.id.btn_login);
        btn_tirkelu=findViewById(R.id.btn_tirkelu);

        regis_email=findViewById(R.id.regis_email);
        regis_password=findViewById(R.id.regis_password);

        storeDatabase=new StoreDatabase(this);
        sqLiteDatabase=storeDatabase.getWritableDatabase();

        btn_tirkelu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registration=new Intent(LoginActivity.this, RegistrationActivity.class);
                startActivity(registration);
            }
        });

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(TextUtils.isEmpty(regis_email.getText())){
                    regis_email.setError("Толық толтырыңыз");
                    return;
                }
                if(TextUtils.isEmpty(regis_password.getText())){
                    regis_password.setError("Толық толтырыңыз");
                    return;
                }
                String uEmail=regis_email.getText().toString();
                String uPass=regis_password.getText().toString();

                Cursor loginCursor=sqLiteDatabase.rawQuery("SELECT * FROM "+TABLE_NAME+" WHERE "+
                        COLUMN_EMAIL+"=? AND " + COLUMN_PASSWORD+"=?", new String[]{uEmail, uPass});

                if(loginCursor != null && loginCursor.getCount()>0){
                    loginCursor.moveToFirst();

                    @SuppressLint("Range")
                    String userName=loginCursor.getString(loginCursor.getColumnIndex(COLUMN_NAME));

                    Toast.makeText(LoginActivity.this, "Қош келдіңіз, "+userName, Toast.LENGTH_LONG).show();
                    Intent registration = new Intent(LoginActivity.this, Profile.class);

                    registration.putExtra("name", userName);
                    registration.putExtra("email", uEmail);
                    registration.putExtra("password", uPass);

                    startActivity(registration);
                }

                else {
                    Toast.makeText(LoginActivity.this, "Пошта немесе құпиясөз қате жазылды!", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}