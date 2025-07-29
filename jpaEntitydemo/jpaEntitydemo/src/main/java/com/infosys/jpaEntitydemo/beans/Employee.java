package com.infosys.jpaEntitydemo.beans;

import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Value;

@Entity
@NamedQuery(
        name = "Employee.findByEmail",
        query = "select e from Employee e where e.empEmail= :mail"
)
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int empId;

    private String empName;
    private String empEmail;

    public Employee(){}

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getEmpEmail() {
        return empEmail;
    }

    public void setEmpEmail(String empEmail) {
        this.empEmail = empEmail;
    }


    public Employee(String empName, String empEmail) {
        this.empName = empName;
        this.empEmail = empEmail;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empId=" + empId +
                ", empName='" + empName + '\'' +
                ", empEmail='" + empEmail + '\'' +
                '}';
    }


}
