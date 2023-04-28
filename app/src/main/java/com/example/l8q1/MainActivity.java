/*
Write a program to create “Contact Book” wherein user has to create the following
a) View that saves the name,phone-no ,email Id of a person.
b) To display the saved contact.
c) To edit the details of any contact
*/

package com.example.l8q1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AbsListView;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button save,display,edit;
    EditText name,email,number;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        save=findViewById(R.id.save);
        display=findViewById(R.id.display);
        edit=findViewById(R.id.edit);
        name=findViewById(R.id.name);
        email=findViewById(R.id.email);
        number=findViewById(R.id.phone);

        //Save
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db myDB = new db(MainActivity.this);
                myDB.addContact(name.getText().toString().trim(),email.getText().toString().trim(),Integer.parseInt(number.getText().toString().trim()));

            }
        });

        //Display
        display.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent j=new Intent(MainActivity.this,MainActivity2.class);
                startActivity(j);
            }
        });

        //Edit
        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity.this,MainActivity3.class);
                startActivity(i);
            }
        });
    }
}