package com.example.apple.sqlliteapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class UpdateActivity extends AppCompatActivity implements View.OnClickListener {
EditText emp_name,emp_address,emp_designation,emp_salary;
Button emp_update;
int id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        emp_name=findViewById(R.id.edtempname);
        emp_address=findViewById(R.id.edtempaddress);
        emp_designation=findViewById(R.id.edtempdesignation);
        emp_salary=findViewById(R.id.edtempsalary);
        emp_update=findViewById(R.id.btnempupdate);
        emp_update.setOnClickListener(this);

        Employee employee = (Employee) getIntent().getSerializableExtra("employee");
        emp_name.setText(employee.getName());
        emp_address.setText(employee.getAddress());
        emp_salary.setText(String.valueOf(employee.getSalary()));
        emp_designation.setText(employee.getDesignation());
        id = employee.getId();
    }


    @Override
    public void onClick(View v) {

        String name = emp_name.getText().toString().trim();
        String designation = emp_designation.getText().toString().trim();
        String salary = emp_salary.getText().toString().trim();
        String address = emp_address.getText().toString().trim();
        if (name.equals("")) {
            emp_name.setError("name is requier");
            emp_name.setHint("Name is requier");
        }
        if (designation.equals("")) {
            emp_designation.setError("designation is requier");
            emp_designation.setHint("designation is requier");
        }
        if (salary.equals("")) {
            emp_salary.setError("salary is requier");
            emp_salary.setHint("salary is requier");
        }
        if (address.equals("")) {
            emp_address.setError("address is requier");
            emp_address.setHint("address is requier");
        }
        Long Salary = Long.parseLong(salary);
        Employee employee = new Employee(name, address, designation, Salary);
        employee.setId(id);
        DBHelper dbHelper=new DBHelper(this);
        dbHelper.updateEmployee(employee);
    }
}

