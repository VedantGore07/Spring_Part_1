package com.infosys.jpaEntitydemo;

import com.infosys.jpaEntitydemo.beans.Employee;
import com.infosys.jpaEntitydemo.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class JpaEntitydemoApplication implements CommandLineRunner {

	@Value("${spring.application.name}")
	private String appName;

	@Autowired
	EmployeeService employeeService;

	public static void main(String[] args) {
		SpringApplication.run(JpaEntitydemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Scanner scanner = new Scanner(System.in);

		System.out.println(appName);
		System.out.println("Enter 1 to add employee");
		System.out.println("Enter 2 to find employee on basis of Id");
		System.out.println("Enter 3 to update employee");
		System.out.println("Enter 4 to remove employee");
		System.out.println("Enter 5 to get all employees");
		System.out.println("Enter 6 to get employee by email");
		System.out.println("Enter 7 to validate employee");

		System.out.println("Enter your choice");
		int choice = scanner.nextInt();

		switch (choice)
		{
			case 1:
				System.out.println("enter employeee name");
				String empName = scanner.next();
				System.out.println("enter employee email");
				String empEmail = scanner.next();

				Employee employee = new Employee();

				employee.setEmpName(empName);
				employee.setEmpEmail(empEmail);

				Employee emp = employeeService.addEmployee(employee);
				System.out.println("Employee saved"+emp.toString());
				break;

			case 2:
				employeeService.findEmployee();
				break;

			case 3:
				System.out.println("enter empId");
				int empId = scanner.nextInt();
				System.out.println("Enter employee Email");
				String empNewEmail = scanner.next();
				employeeService.updateEmail(empId, empNewEmail);
				break;

			case 4:
				System.out.println("enter empId to remove");
				int eId = scanner.nextInt();
				employeeService.removeEmployee(eId);
				break;

			case 5:
				List<Employee> employeeList = employeeService.findAllEmployee();
				employeeList.forEach(employee1 -> System.out.println(employee1.toString()));
				break;

			case 6:
				System.out.println("Enter employee email");
				String femail = scanner.next();
				employeeService.findByEmail(femail);
				break;

			case 7:

		}
	}
}
