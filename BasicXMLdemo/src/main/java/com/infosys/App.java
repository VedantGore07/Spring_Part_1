package com.infosys;

import com.infosys.beans.Department;
import com.infosys.beans.Employee;
import com.infosys.beans.Project;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        Employee employee = (Employee) context.getBean("emp");
        System.out.println("Employee Name: "+employee.getEmpName());
        System.out.println( "Employee Id: "+employee.getEmpId() );

//        Department department = context.getBean(Department.class);
        Department department = (Department) context.getBean("depart1");
        System.out.println(department.toString());

        Project project = context.getBean(Project.class);
        System.out.println(project.toString());
        project.showEmployee();
        project.showResources();


    }
}
