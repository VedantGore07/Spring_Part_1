package com.infosys.jpaEntitydemo.services;

import com.infosys.jpaEntitydemo.beans.Employee;
import com.infosys.jpaEntitydemo.dao.EmployeeDao;
import jakarta.persistence.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Scanner;

@Service
public class EmployeeService implements EmployeeDao {

    EntityManagerFactory emf;
    @PersistenceUnit
    public void setEntityManagerFactory(EntityManagerFactory emf){
        this.emf = emf;
    }

    @Override
    public Employee addEmployee(Employee emp) {
        EntityManager entityManager = emf.createEntityManager();
        // begin transaction to make changes
        entityManager.getTransaction().begin();
        entityManager.persist(emp);
        //persist() to save object entity
        entityManager.getTransaction().commit();  // commit the current resource transaction
        return emp;
    }

    @Override
    public void findEmployee() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter empId to search");
        int empId = scanner.nextInt();

        EntityManager entityManager = emf.createEntityManager();
        // begin transaction to make changes
        entityManager.getTransaction().begin();

        Employee e = entityManager.find(Employee.class, empId);

        if(e!=null)
        {
            System.out.println("Employee Name: "+e.getEmpName());
            System.out.println("Employee Email: "+e.getEmpEmail());
        }else{
            System.out.println("Employee not found. please check Id");
        }

        entityManager.getTransaction().commit();
        entityManager.close();

    }

    @Override
    public void updateEmail(int empId, String empEmail) {

        EntityManager entityManager = emf.createEntityManager();
        // begin transaction to make changes
        entityManager.getTransaction().begin();

        Employee e = entityManager.find(Employee.class, empId);

        if(e!=null)
        {
            System.out.println("Employee old email: "+e.getEmpEmail());
            e.setEmpEmail(empEmail);
            System.out.println("Employee new details: "+e.toString());
        }else{
            System.out.println("Employee not found. please check Id");
        }

        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public void removeEmployee(int empId) {

        EntityManager entityManager = emf.createEntityManager();
        // begin transaction to make changes
        entityManager.getTransaction().begin();

        Employee e = entityManager.find(Employee.class, empId);

        if(e!=null)
        {
            entityManager.remove(e);
            System.out.println("Employee is remove");
        }else{
            System.out.println("Employee not found. please check Id");
        }

        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public List<Employee> findAllEmployee() {
        String query = "select e from Employee e";
        EntityManager entityManager = emf.createEntityManager();
        TypedQuery<Employee> empList = entityManager.createQuery(query,Employee.class);
        List<Employee> empResultList = empList.getResultList();

        return empResultList;
    }

    @Override
    public void findByEmail(String mailId) {
        EntityManager entityManager = emf.createEntityManager();
        List<Employee> employeeList = entityManager.createNamedQuery("Employee.findByEmail", Employee.class)
                .setParameter("mail",mailId).getResultList();

        if(employeeList.size() >= 0){
            employeeList.forEach(employee1 -> System.out.println(employee1.toString()));
        }
        else{
            System.out.println("no data found");
        }
    }

    @Override
    public boolean validateEmployee(int empId, String empEmail) {

        boolean validate  = false;

        EntityManager entityManager = emf.createEntityManager();
        entityManager.getTransaction().begin();    // state of emp object is transient
        Employee e = entityManager.find(Employee.class, empId);
        if(e != null){
            if(!Objects.equals(e.getEmpEmail(), empEmail)) {
                System.out.println("Invalid email id");
            } else {
                System.out.println("Valid email id and employee");
            }
        }
        else{
            System.out.println("Employee not found");
        }
        entityManager.getTransaction().commit(); // commit the persistence
        entityManager.close();
    }
}
