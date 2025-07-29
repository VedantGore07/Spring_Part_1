package com.vedant.courseManagement.services;

import com.vedant.courseManagement.beans.Courses;
import com.vedant.courseManagement.repos.CourseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseServices implements CourseServicesInterface{

    @Autowired
    CourseRepo courseRepo;


    @Override
    public void addCourse(Courses courses) {
        courseRepo.save(courses);
    }

    @Override
    public Optional<Courses> findCourseById(int courseId) {
        return courseRepo.findById(courseId);
    }

    @Override
    public void updateCourse(Courses courses) {
        courseRepo.save(courses);
    }

    @Override
    public void deleteCourse(int CourseId) {
        courseRepo.deleteById(CourseId);
    }

    public List<Courses> getByInstructor(String instructor) {
        return courseRepo.findByCourseInstructor(instructor);
    }

    public List<Courses> getByCategory(String category) {
        return courseRepo.findByCourseCategory(category);
    }

    public List<Courses> getBySchedule(String yearOrMonth) {
        return courseRepo.findByCourseScheduleContaining(yearOrMonth);
    }

}
