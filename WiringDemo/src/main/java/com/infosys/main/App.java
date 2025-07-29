package com.infosys.main;

import com.infosys.bean.Developer;
import com.infosys.config.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args )
    {
        AnnotationConfigApplicationContext context= new AnnotationConfigApplicationContext(AppConfig.class);
        Developer dev= context.getBean(Developer.class);
        System.out.println("Developer name : " + dev.getDeveloperName());
        System.out.println("Team name : " + dev.getTeamName());
        System.out.println("Project name : " + dev.getProject().getProjectName());
    }
}