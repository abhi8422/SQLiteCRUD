package com.example.apple.sqlliteapp;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText empname, empdesignaton, empsalary, empaddress;
    String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        empname = findViewById(R.id.edtempname);
        empdesignaton = findViewById(R.id.edtempaddress);
        empsalary = findViewById(R.id.edtempsalary);
        empaddress = findViewById(R.id.edtempaddress);
    }

    public void save(View view) {
        name = empname.getText().toString().trim();
        String designation = empdesignaton.getText().toString().trim();
        String salary = empsalary.getText().toString().trim();
        String address = empaddress.getText().toString().trim();
        Long Salary = Long.parseLong(salary);
        if (name.equals("")) {
            empname.setError("name is requier");
            empname.setHint("Name is requier");
        }
        if (designation.equals("")) {
            empname.setError("designation is requier");
            empname.setHint("designation is requier");
        }
        if (salary.equals("")) {
            empname.setError("salary is requier");
            empname.setHint("salary is requier");
        }
        if (address.equals("")) {
            empname.setError("address is requier");
            empname.setHint("address is requier");
        }
        Employee employee = new Employee(name, address, designation, Salary);
        DBHelper dbHelper = new DBHelper(this);
        boolean inInserted = dbHelper.insertEmployee(employee);
        if (inInserted)
            Toast.makeText(MainActivity.this, "Record inserted", Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(MainActivity.this, "Record is not inserted", Toast.LENGTH_SHORT).show();
    }



    // public void delete(View view) {
    //   DBHelper dbHelper=new DBHelper(this);
    // Cursor data= dbHelper.getItemID(name);

}

