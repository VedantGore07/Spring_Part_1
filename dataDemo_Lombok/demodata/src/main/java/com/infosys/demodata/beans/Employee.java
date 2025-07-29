package com.infosys.demodata.beans;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity // specifies class is an entity  (this notation applied to entity class)

@Table(name = "tb_emp")
public class Employee {

    @Id  // specifies primary key for an entity
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // auto generated
    private @Getter @Setter int empId;

    @Column
    private @Getter @Setter String empName;

    @Column(name = "emp_dept")
    private @Getter @Setter String deptName;

    public Employee(String empName, String deptName){

        this.empName = empName;
        this.deptName = deptName;

    }
}
