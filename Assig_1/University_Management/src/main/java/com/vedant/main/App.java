package com.vedant.main;

import com.vedant.beans.UniversityService;
import com.vedant.config.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        UniversityService service = context.getBean(UniversityService.class);

        service.getStudent().setName("Vedant");
        service.getStudent().setId(36);
        service.getCourse().setCourseName("Information Technology");

        System.out.println("Student ID: " + service.getStudent().getId());
        System.out.println("Student Name: " + service.getStudent().getName());
        System.out.println("Course Name: " + service.getCourse().getCourseName());
        context.close();
    }
}
