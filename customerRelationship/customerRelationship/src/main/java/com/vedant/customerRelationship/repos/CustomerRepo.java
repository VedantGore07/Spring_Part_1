package com.vedant.customerRelationship.repos;

import com.vedant.customerRelationship.beans.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepo extends JpaRepository<Customer, Integer> {

}
