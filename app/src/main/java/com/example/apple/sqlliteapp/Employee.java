package com.example.apple.sqlliteapp;

import java.io.Serializable;

public class Employee implements Serializable {
    String name,address,designation;
            Long salary;int id;

    public Employee(String name, String address, String designation, Long salary) {
        this.name = name;
        this.address = address;
        this.designation = designation;
        this.salary = salary;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public Long getSalary() {
        return salary;
    }

    public void setSalary(Long salary) {
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
