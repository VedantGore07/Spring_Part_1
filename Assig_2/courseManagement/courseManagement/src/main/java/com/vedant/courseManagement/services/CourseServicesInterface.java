package com.vedant.courseManagement.services;

import com.vedant.courseManagement.beans.Courses;

import java.util.List;
import java.util.Optional;

public interface CourseServicesInterface {

    void addCourse(Courses courses);
    Optional<Courses> findCourseById(int courseId);
    void updateCourse(Courses courses);
    void deleteCourse(int CourseId);

    List<Courses> getByInstructor(String instructor);
    List<Courses> getByCategory(String category);
    List<Courses> getBySchedule(String schedule);

}
