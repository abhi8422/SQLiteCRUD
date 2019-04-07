package com.example.apple.sqlliteapp;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ShowEmployee extends AppCompatActivity {
RecyclerView recyclerView; int position;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_employee);
        recyclerView=findViewById(R.id.recycler);
        DBHelper dbHelper= new DBHelper(ShowEmployee.this);
        List<Employee> employeeList= dbHelper.getEmployee();
        EmployeeAadapter employeeAadapter=new EmployeeAadapter(employeeList,this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(employeeAadapter);


        //for(Employee employee :employeeList){
            //Toast.makeText(ShowEmployee.this,"Name :"+employee.getName()+"Designation :"+employee.getDesignation()+
            //"Address :"+employee.getAddress()+"Salary :"+employee.getSalary(),Toast.LENGTH_SHORT).show();
        //}

    }
}
