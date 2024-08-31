package com.example.digitaluniver;

import static com.example.digitaluniver.StoreDatabase.COLUMN_EMAIL;
import static com.example.digitaluniver.StoreDatabase.COLUMN_NAME;
import static com.example.digitaluniver.StoreDatabase.COLUMN_PASSWORD;
import static com.example.digitaluniver.StoreDatabase.TABLE_NAME;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class RegistrationActivity extends AppCompatActivity {

    EditText regis_name, regis_email, regis_password;
    Button btn_tirkelu;
    StoreDatabase storeDatabase;
    SQLiteDatabase sqLiteDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        regis_name=findViewById(R.id.regis_name);
        regis_email=findViewById(R.id.regis_email);
        regis_password=findViewById(R.id.regis_password);
        btn_tirkelu=findViewById(R.id.btn_tirkelu);
        storeDatabase=new StoreDatabase(this);
        sqLiteDatabase=storeDatabase.getWritableDatabase();


        btn_tirkelu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(TextUtils.isEmpty(regis_name.getText())){
                    regis_name.setError("Толық толтырыңыз");
                    return;
                }
                if(TextUtils.isEmpty(regis_email.getText())){
                    regis_email.setError("Толық толтырыңыз");
                    return;
                }
                if(TextUtils.isEmpty(regis_password.getText())){
                    regis_password.setError("Толық толтырыңыз");
                    return;
                }
                ContentValues values=new ContentValues();
                values.put(COLUMN_NAME, regis_name.getText().toString());
                values.put(COLUMN_EMAIL, regis_email.getText().toString());
                values.put(COLUMN_PASSWORD, regis_password.getText().toString());
                sqLiteDatabase.insert(TABLE_NAME, null, values);

                Intent registration=new Intent(RegistrationActivity.this, LoginActivity.class);
                startActivity(registration);

            }
        });
    }
}