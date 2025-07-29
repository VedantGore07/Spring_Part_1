package com.vedant.employeeManagement.services;

import com.vedant.employeeManagement.beans.Employees;
import com.vedant.employeeManagement.repos.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServices implements EmployeeServicesInterface {

    @Autowired
    EmployeeRepo employeeRepo;


    @Override
    public void addEmployees(Employees employee) {
        employeeRepo.save(employee);
    }

    @Override
    public Optional<Employees> findEmployeeById(int employeeId) {
        return employeeRepo.findById(employeeId);
    }

    @Override
    public void updateEmployee(Employees employee) {
        employeeRepo.save(employee);
    }

    @Override
    public void deleteEmployee(int employeeId) {
        employeeRepo.deleteById(employeeId);
    }

    @Override
    public List<Employees> getEmployeesByDepartment(String department) {
        return employeeRepo.findByEmpDepartment(department);
    }

    @Override
    public List<Employees> getEmployeesByRole(String role) {
        return employeeRepo.findByEmpRole(role);
    }

    @Override
    public List<Employees> getEmployeesByLocation(String location) {
        return employeeRepo.findByEmpLocation(location);
    }


}
