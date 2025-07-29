package com.infosys.bean;

import org.springframework.stereotype.Component;

@Component
public class Project {

    private String projectName = "Finacle";

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }


}