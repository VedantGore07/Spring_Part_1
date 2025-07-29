package com.vedant.courseManagement.repos;

import com.vedant.courseManagement.beans.Courses;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRepo extends JpaRepository<Courses,Integer> {

    List<Courses> findByCourseInstructor(String courseInstructor);
    List<Courses> findByCourseCategory(String courseCategory);
    List<Courses> findByCourseScheduleContaining(String schedulePart);

}
