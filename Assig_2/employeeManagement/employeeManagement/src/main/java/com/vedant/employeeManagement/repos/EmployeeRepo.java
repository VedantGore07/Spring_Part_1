package com.vedant.employeeManagement.repos;

import com.vedant.employeeManagement.beans.Employees;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepo extends JpaRepository<Employees, Integer> {

    List<Employees> findByEmpDepartment(String department);

    List<Employees> findByEmpRole(String role);

    List<Employees> findByEmpLocation(String location);
}
