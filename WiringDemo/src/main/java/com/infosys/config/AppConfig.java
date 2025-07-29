package com.infosys.config;

import com.infosys.bean.Developer;
import com.infosys.bean.Project;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//wiring using method call
@Configuration
public class AppConfig {

    @Bean
    public Project project(){
        Project p= new Project();
        p.setProjectName("Finacle");
        return p;
    }

    //developer bean is dependent on project bean
    @Bean
    public Developer developer(){
        Developer dev= new Developer();
        dev.setDeveloperName("Virat");
        dev.setTeamName("Backend");
        dev.setProject(project());
        return dev;
    }

    //wiring using method call

}