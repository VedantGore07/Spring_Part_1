package com.infosys.mappingdemo.repos;

import com.infosys.mappingdemo.beans.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepo extends JpaRepository<Student, Integer> {

    List<Student> findByDepartmentDeptId(int deptId);

}
