package com.infosys.mappingdemo.services;


import com.infosys.mappingdemo.beans.Student;
import com.infosys.mappingdemo.repos.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService implements StudentServiceInterface{

    @Autowired
    StudentRepo studentRepo;

    @Override
    public void addStudent(Student student) {
        studentRepo.save(student);
    }
}
