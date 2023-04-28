package com.example.l8q1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class db extends SQLiteOpenHelper {
    private Context context;
    private static final String DATABASE_NAME="phoneBook.db";
    private static final int DATABASE_VERSION=1;
    private static final String TABLE_NAME="Contacts";
    private static final String col_name="Name";
    private static final String col_email="Email";
    private static final String col_number="Phone";
    public db(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context=context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query="CREATE TABLE "+TABLE_NAME+
                "("+col_name+" TEXT PRIMARY KEY, "+
                col_email+" TEXT, "+
                col_number+" INTEGER);";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+DATABASE_NAME);
        onCreate(db);
    }

    void addContact(String name, String email, int number){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();

        cv.put(col_name,name);
        cv.put(col_email,email);
        cv.put(col_number,number);
        long result = db.insert(TABLE_NAME,null,cv);
        if(result==-1){
            Toast.makeText(context,"Fail!",Toast.LENGTH_LONG).show();
        }
        else {
            Toast.makeText(context,"Success!",Toast.LENGTH_LONG).show();
        }
    }

    Cursor readData(){
        String query="SELECT * FROM "+DATABASE_NAME+";";
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=null;
        if(db!=null){
            cursor=db.rawQuery(query,null);
        }
        return cursor;
    }
}
