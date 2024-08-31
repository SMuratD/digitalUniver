package com.example.digitaluniver;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.LinkedList;

public class DBHelper extends SQLiteOpenHelper {
    private static final String MY_TABLE = "MY_TABLE";
    private static final String COLUMN_NAME = "COLUMN_NAME";
    private static final String COLUMN_SURNAME = "COLUMN_SURNAME";
    private static final String COLUMN_YEAR = "COLUMN_YEAR";

    public DBHelper(@Nullable Context context) {
        super(context, "example.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + MY_TABLE + " (" + COLUMN_NAME + " TEXT, " + COLUMN_SURNAME + " TEXT, " + COLUMN_YEAR + " INTEGER);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void DeleteAll(){
        SQLiteDatabase db=this.getWritableDatabase();
        db.delete(MY_TABLE, null, null);
        db.close();
    }
    public void AddOne(Date date){
        SQLiteDatabase db=this.getWritableDatabase();

        ContentValues cv=new ContentValues();
        cv.put(COLUMN_NAME, date.name);
        cv.put(COLUMN_SURNAME, date.surname);
        cv.put(COLUMN_YEAR, date.year);

        db.insert(MY_TABLE, null, cv);
        db.close();
    }
    public LinkedList<Date> GetAll(){
        LinkedList<Date> list =new LinkedList<>();
        SQLiteDatabase db=this.getWritableDatabase();

        Cursor cursor=db.query(MY_TABLE, null, null, null, null, null, null);
        if(cursor.moveToFirst())
            do{
                int id_n=cursor.getColumnIndex(COLUMN_NAME);
                int id_s=cursor.getColumnIndex(COLUMN_SURNAME);
                int id_y=cursor.getColumnIndex(COLUMN_YEAR);

                Date date=new Date(cursor.getString(id_n), cursor.getString(id_s), cursor.getInt(id_y));
                list.add(date);
            }while(cursor.moveToNext());
        db.close();
        return list;
    }
}
