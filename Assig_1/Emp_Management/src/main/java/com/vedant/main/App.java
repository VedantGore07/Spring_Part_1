package com.vedant.main;

import com.vedant.beans.Employee;
import com.vedant.config.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App
{
    public static void main( String[] args )
    {
        AnnotationConfigApplicationContext context= new AnnotationConfigApplicationContext(AppConfig.class);
        Employee emp= context.getBean(Employee.class);
        emp.setId(101);
        emp.setName("Vedant");
        emp.setDesignation("Product Developer");
        emp.setSalary(66000.0);

        System.out.println("Employee ID     : " + emp.getId());
        System.out.println("Employee Name   : " + emp.getName());
        System.out.println("Designation     : " + emp.getDesignation());
        System.out.println("Salary          : " + emp.getSalary());
        System.out.println("Address Street  : " + emp.getAddress().getStreet());
        System.out.println("Address City    : " + emp.getAddress().getCity());
        System.out.println("Address State   : " + emp.getAddress().getState());
        System.out.println("Address Zipcode : " + emp.getAddress().getZipcode());


        context.close();
    }
}