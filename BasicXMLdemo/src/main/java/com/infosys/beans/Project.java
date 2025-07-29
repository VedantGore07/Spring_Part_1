package com.infosys.beans;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

public class Project {

    private String projectName;
    private Department department;
    private List<Employee> employeeList;
    private Map<String, Integer> resources;


    @Autowired
    public Project(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public Department getDepartment() {
        return department;
    }

    @Autowired
    public void setDepartment(Department department) {
        this.department = department;
    }

    public Map<String, Integer> getResources() {
        return resources;
    }

    public void setResources(Map<String, Integer> resources) {
        this.resources = resources;
    }



    @Override
    public String toString() {
        return "Project{" +
                "projectName='" + projectName + '\'' +
                ", department=" + department +
                ", employeeList=" + employeeList +
                '}';
    }

    public void showEmployee(){
        employeeList.forEach(employee1 -> {
            System.out.println(employee1.getEmpName());
        });
    }

    public  void showResources()
    {
        for( Map.Entry<String,Integer> resource : resources.entrySet())
        {
            System.out.println(resource.getKey() + "-"+resource.getValue());
        }
    }
}
