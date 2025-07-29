package com.infosys.dataDemo.beans;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity //Specifies that the class is an entity
@Table(name = "employee")//by default table will be created with same name as that of class name
@Getter
@Setter
public class Employee {

    @Id //specifies the primary key for entity
    @GeneratedValue(strategy = GenerationType.IDENTITY) //auto geenrated
    private int empId;

    @Column(name = "employee_name")
    private String empName;

    @Column(name = "employee_department")
    private String empDept;

    public Employee(String empName, String empDept){
        this.empName= empName;
        this.empDept= empDept;
    }
}
