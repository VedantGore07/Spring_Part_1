package com.vedant.Ecommerce.repos;

import com.vedant.Ecommerce.beans.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepo extends JpaRepository<Order, Integer> {
}