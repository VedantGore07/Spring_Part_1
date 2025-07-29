package com.vedant.beans;

import org.springframework.beans.factory.annotation.Autowired;

public class Employee {
    private int id;
    private String name, designation;
    private double salary;

    @Autowired
    private Address address;

    public Address getAddress() {
        return address;
    }


    public void setAddress(Address project) {
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

}

