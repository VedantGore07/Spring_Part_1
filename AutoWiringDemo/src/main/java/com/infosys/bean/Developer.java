package com.infosys.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Developer {

    private String developerName;
    private String teamName;

//    //1. field level autowiring (injection)
//    @Autowired(required = false)
//    private Project project;


//    //2. Constructor injection
//    private Project project; 
//
//    public Developer(Project project){
//        System.out.println("developer bean creating...");
//        this.project= project;
//    }

    private Project project;

    public String getDeveloperName() {
        return developerName;
    }

    public void setDeveloperName(String developerName) {
        this.developerName = developerName;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public Project getProject() {
        return project;
    }

//    3. setter type injection
    @Autowired
    public void setProject(Project project) {
        this.project = project;
    }


}