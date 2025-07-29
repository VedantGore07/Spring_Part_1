package com.infosys.curddemo.services;

import com.infosys.curddemo.beans.Student;
import com.infosys.curddemo.repos.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService implements StudentServiceInterface{

    @Autowired
    StudentRepo studentRepo;

    @Override
    public List<Student> findAllStudent() {
        return studentRepo.findAllStudent();
    }
}
