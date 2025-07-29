package com.infosys.curddemo.repos;

import com.infosys.curddemo.beans.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepo extends JpaRepository<Student, Integer> {

    List<Student> findAllStudent();
    Student findByEmail(@Param("email") String studentEmail);
}
