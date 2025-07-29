package com.infosys.mappingdemo.services;

import com.infosys.mappingdemo.beans.Department;
import com.infosys.mappingdemo.beans.Student;

import java.util.List;

public interface DepartmentServiceInterface {


    public void saveDepartment(Department department);
    public List<Department> getAllDepartment();
    public Department findDepartment(int deptId);

}
