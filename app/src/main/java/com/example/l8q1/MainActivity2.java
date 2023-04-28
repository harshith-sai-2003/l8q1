package com.example.l8q1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {
    RecyclerView rv;
    db myDB;
    ArrayList<String> colName,colEmail,colNumber;
    customAdapter customAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        RecyclerView recyclerView=findViewById(R.id.disp);
        myDB=new db(MainActivity2.this);
        colEmail=new ArrayList<>();
        colName=new ArrayList<>();
        colNumber=new ArrayList<>();
        displayData();
        customAdapter=new customAdapter(MainActivity2.this,colName,colEmail,colNumber);
        recyclerView.setAdapter(customAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity2.this));
    }

    void displayData(){
        Cursor cursor=myDB.readData();
        if(cursor.getCount()==0){
            Toast.makeText(this,"No available data",Toast.LENGTH_LONG).show();
        }
        else{
            if(cursor.moveToFirst()) {
                while (cursor.moveToNext()) {
                    colName.add(cursor.getString(0));
                    colEmail.add(cursor.getString(1));
                    colNumber.add(cursor.getString(2));
                }
            }
        }
    }
}