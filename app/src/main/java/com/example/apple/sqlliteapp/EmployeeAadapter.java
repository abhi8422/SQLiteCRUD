package com.example.apple.sqlliteapp;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import java.util.List;

public class EmployeeAadapter extends RecyclerView.Adapter<EmployeeAadapter.EmployeeViewHolder> {
    List<Employee> employeeList;
    Context context;
    DBHelper dbHelper;

    public EmployeeAadapter(List<Employee> employeeList, Context context) {
        this.employeeList = employeeList;
        this.context = context;
        dbHelper=new DBHelper(context);
    }

    @NonNull
    @Override
    public EmployeeAadapter.EmployeeViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view=LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.employee_item,null);
        return new EmployeeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EmployeeViewHolder employeeViewHolder, int i) {
        Employee employee=employeeList.get(i);
        employeeViewHolder.empName.setText("Name :"+employee.getName());
        employeeViewHolder.empAddress.setText("Address :"+employee.getAddress());
        employeeViewHolder.empDesignation.setText("Designation :"+employee.getDesignation());
        employeeViewHolder.empSalary.setText("Salary :"+employee.getSalary());

    }
    @Override
    public int getItemCount() {
        return employeeList.size();
    }
     class EmployeeViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView empName,empAddress,empDesignation,empSalary;
        ImageView empDelete;
         EmployeeViewHolder(@NonNull View itemView) {
            super(itemView);
            empName=itemView.findViewById(R.id.txtName);
            empAddress=itemView.findViewById(R.id.txtAddress);
            empDesignation=itemView.findViewById(R.id.txtDesignation);
            empSalary=itemView.findViewById(R.id.txtSalary);
            empDelete=itemView.findViewById(R.id.imgDelete);
            empDelete.setOnClickListener(this);
             itemView.setOnClickListener(new View.OnClickListener() {
                 @Override
                 public void onClick(View view) {
                     int position = getAdapterPosition();
                     Employee employee = employeeList.get(position);
                     Intent intent = new Intent(context, UpdateActivity.class);
                     intent.putExtra("employee", employee);
                     context.startActivity(intent);
                 }
             });

         }

        @Override
        public void onClick(View v) {
            Toast.makeText(context, "Delete button clicked", Toast.LENGTH_SHORT).show();
            int postion= getAdapterPosition();
            Employee employee=employeeList.get(postion);
            boolean isDelted=dbHelper.deleteEmployee(employee.getId());
            if(isDelted){
                employeeList.remove(postion);
                notifyDataSetChanged();
            }
        }
    }
}
