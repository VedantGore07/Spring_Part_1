package com.vedant.inventoryManagement.repos;

import com.vedant.inventoryManagement.beans.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepo extends JpaRepository<Products, Integer> {

    List<Products> findByCategory(String category);

    List<Products> findByPriceBetween(double min, double max);

}
