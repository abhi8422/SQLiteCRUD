package com.example.apple.sqlliteapp;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class HomeActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_activity);
    }
    public void Add(View view) {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }
    public void Show(View view) {
       Intent i = new Intent(this, ShowEmployee.class);
        startActivity(i);
    }
    public void Update(View view){

    }


}
