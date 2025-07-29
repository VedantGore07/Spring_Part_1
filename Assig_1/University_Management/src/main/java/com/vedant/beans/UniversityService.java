package com.vedant.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UniversityService {

    private Student student;
    private Course course;

    public Student getStudent() {
        return student;
    }

    public Course getCourse() {
        return course;
    }

    @Autowired
    public void setStudent(Student student) {
        this.student = student;
    }

    @Autowired
    public void setCourse(Course course) {
        this.course = course;
    }
}
