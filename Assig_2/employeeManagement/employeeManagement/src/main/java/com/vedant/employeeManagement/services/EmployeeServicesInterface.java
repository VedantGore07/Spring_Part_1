package com.vedant.employeeManagement.services;

import com.vedant.employeeManagement.beans.Employees;

import java.util.List;
import java.util.Optional;

public interface EmployeeServicesInterface {

    void addEmployees(Employees employee);
    Optional<Employees> findEmployeeById(int employeeId);
    void updateEmployee(Employees employee);
    void deleteEmployee(int employeeId);

    List<Employees> getEmployeesByDepartment(String department);
    List<Employees> getEmployeesByRole(String role);
    List<Employees> getEmployeesByLocation(String location);

}
