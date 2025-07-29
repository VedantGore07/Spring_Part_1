package com.vedant.Ecommerce.repos;

import com.vedant.Ecommerce.beans.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer> {

    List<Product> findByCategories_CategoryId(int categoryId);
}