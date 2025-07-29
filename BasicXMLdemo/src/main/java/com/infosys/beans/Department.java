package com.infosys.beans;

public class Department {

    private String deptName;
    private int deptId;

    @Override
    public String toString() {
        return "Department{" +
                "deptName='" + deptName + '\'' +
                ", deptId=" + deptId +
                '}';
    }


    public Department(String deptName, int deptId) {
        this.deptName = deptName;
        this.deptId = deptId;
    }


}
