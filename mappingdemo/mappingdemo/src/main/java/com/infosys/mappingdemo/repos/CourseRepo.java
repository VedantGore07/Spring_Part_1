package com.infosys.mappingdemo.repos;

import com.infosys.mappingdemo.beans.Courses;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepo extends JpaRepository<Courses, Integer> {

}
