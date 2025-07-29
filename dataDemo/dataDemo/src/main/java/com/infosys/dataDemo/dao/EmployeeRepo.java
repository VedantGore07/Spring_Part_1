package com.infosys.dataDemo.dao;

import com.infosys.dataDemo.beans.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
//CrudRepository<T, ID> ==  CrudRepository<Object, DataType of primary key>
public interface EmployeeRepo extends CrudRepository<Employee, Integer> {

}
