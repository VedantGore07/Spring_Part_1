package com.infosys.jpaEntitydemo.dao;

import com.infosys.jpaEntitydemo.beans.Employee;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeDao {

    public Employee addEmployee(Employee emp);
    public void findEmployee();
    public void updateEmail(int empId, String empEmail);
    public void removeEmployee(int empId);
    public List<Employee> findAllEmployee();
    public void findByEmail(String mailId);
    public boolean validateEmployee(int empId, String empEmail);

}
