package com.vedant.employeeManagement;

import com.vedant.employeeManagement.beans.Employees;
import com.vedant.employeeManagement.services.EmployeeServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

@SpringBootApplication
public class EmployeeManagementApplication implements CommandLineRunner {

	@Autowired
	EmployeeServices employeeServices;

	@Value("${spring.application.name}")
	private String appName;

	public static void main(String[] args) {
		SpringApplication.run(EmployeeManagementApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Scanner scanner = new Scanner(System.in);

		System.out.println(appName);
		System.out.println("Enter 1 to add new Employee");
		System.out.println("Enter 2 to find the Employee on basis of id");
		System.out.println("Enter 3 to update Employee details");
		System.out.println("Enter 4 to remove Employee");
		System.out.println("Enter 5 Fetch Employees by Department");
		System.out.println("Enter 6 Fetch Employees by Role");
		System.out.println("Enter 7 Fetch Employees by Location");
		System.out.println("Enter your choice :-");


		int Operation =scanner.nextInt();
		switch (Operation) {
			case 1:
				System.out.println("Enter Employee Name");
				String employeeName = scanner.next();
				System.out.println("Enter Employee Role ");
				String employeeRole= scanner.next();
				System.out.println("Enter Employee Department");
				String employeeDepartment = scanner.next();
				System.out.println("Enter Employee Salary");
				double employeeSalary = scanner.nextDouble();
				System.out.println("Enter Employee location");
				String employeeLocation = scanner.next();

				Employees employees1 = new Employees();
				employees1.setEmpName(employeeName);
				employees1.setEmpRole(employeeRole);
				employees1.setEmpDepartment(employeeDepartment);
				employees1.setEmpSalary(employeeSalary);
				employees1.setEmpLocation(employeeLocation);

				employeeServices.addEmployees(employees1);
				break;

			case 2:
				System.out.println("Enter EmployeeID to see Product details");
				int employeeId = scanner.nextInt();
				try {
					Optional<Employees> optional = employeeServices.findEmployeeById(employeeId);
					Employees employees = optional.get();
					System.out.println(employees.toString());
				} catch (Exception e) {
					System.err.println("Id not found");
				}
				break;

			case 3:
				System.out.println("Enter EmployeeId to update:");
				int updateId = scanner.nextInt();
				Optional<Employees> optionalEmployees = employeeServices.findEmployeeById(updateId);
				if (optionalEmployees.isPresent()) {
					Employees existingEmployee = optionalEmployees.get();
					System.out.println("Existing Details:");
					System.out.println("EmployeeName: " + existingEmployee.getEmpName());
					System.out.println("EmployeeRole: " + existingEmployee.getEmpRole());
					System.out.println("EmployeeDepartment: " + existingEmployee.getEmpDepartment());
					System.out.println("EmployeeSalary:" + existingEmployee.getEmpSalary());
					System.out.println("EmployeeLocation:" + existingEmployee.getEmpLocation());

					System.out.println("Enter Employee Name");
					String newName = scanner.next();
					System.out.println("Enter Employee Role ");
					String newRole = scanner.next();
					System.out.println("Enter Employee Department");
					String newDepartment = scanner.next();
					System.out.println("Enter Employee Salary");
					int newSalary = scanner.nextInt();
					System.out.println("Enter Employee location");
					String newLocation =scanner.next();

					existingEmployee.setEmpName(newName);
					existingEmployee.setEmpRole(newRole);
					existingEmployee.setEmpDepartment(newDepartment);
					existingEmployee.setEmpSalary(newSalary);
					existingEmployee.setEmpLocation(newLocation);


					employeeServices.updateEmployee(existingEmployee);
					System.out.println("Employee updated successfully.");
				}else {
					System.out.println("Employee not found with ID: " + updateId);
				}
				break;

			case 4:
				System.out.println("Enter Employee ID to delete:");
				int deleteId = scanner.nextInt();
				try {
					employeeServices.deleteEmployee(deleteId);
					System.out.println("Employee deleted successfully.");
				} catch (Exception e) {
					System.out.println("Failed to delete. ID may not exist.");
				}
				break;
			case 5:
				System.out.print("Enter Department: ");
				scanner.nextLine(); // Clear leftover newline if any
				String dept = scanner.nextLine().trim(); // Trim extra spaces
				List<Employees> deptList = employeeServices.getEmployeesByDepartment(dept);

				if (deptList.isEmpty()) {
					System.out.println("No employees found in department: " + dept);
				} else {
					deptList.forEach(System.out::println);
				}
				break;


			case 6:
				System.out.print("Enter Role: ");
				scanner.nextLine(); // Clear leftover newline if any
				String role = scanner.nextLine().trim();
				List<Employees> roleList = employeeServices.getEmployeesByRole(role);
				if (roleList.isEmpty()) {
					System.out.println("No employees found with role: " + role);
				} else {
					roleList.forEach(System.out::println);
				}
				break;

			case 7:
				System.out.print("Enter Location: ");
				scanner.nextLine(); // Clear leftover newline if any
				String location = scanner.nextLine().trim();
				List<Employees> locationList = employeeServices.getEmployeesByLocation(location);
				if (locationList.isEmpty()) {
					System.out.println("No employees found in location: " + location);
				} else {
					locationList.forEach(System.out::println);
				}
				break;

			default:
				System.out.println("Please select valid operation. Thank you!");
		}

	}
}
