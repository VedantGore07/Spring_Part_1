package com.vedant.inventoryManagement.services;

import com.vedant.inventoryManagement.beans.Products;

import java.util.List;
import java.util.Optional;

public interface ProductServiceInterface {

    void addProduct(Products product);

    void addMultipleProducts(List<Products> ProductsList);

    Optional<Products> getProductById(int id);

    void updateProduct(Products product);

    void deleteProduct(int ProductId);

    List<Products> getAllProducts();
}
