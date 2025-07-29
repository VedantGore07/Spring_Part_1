package com.vedant.Ecommerce.repos;

import com.vedant.Ecommerce.beans.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo  extends JpaRepository<User, Integer> {
}
