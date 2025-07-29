package com.vedant.inventoryManagement.services;

import com.vedant.inventoryManagement.beans.Products;
import com.vedant.inventoryManagement.repos.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServices implements ProductServiceInterface {

    @Autowired
    ProductRepo productRepo;

    @Override
    public void addProduct(Products product) {
        productRepo.save(product);
    }

    @Override
    public void addMultipleProducts(List<Products> ProductsList) {
        Iterable<Products> productInfo =  productRepo.saveAll(ProductsList);
    }

    @Override
    public Optional<Products> getProductById(int id) {
        return productRepo.findById(id);
    }

    @Override
    public void updateProduct(Products product) {
        productRepo.save(product);
    }


    @Override
    public void deleteProduct(int ProductId) {
        productRepo.deleteById(ProductId);
    }

    @Override
    public List<Products> getAllProducts() {
        return productRepo.findAll();
    }


    public List<Products> getProductsByCategory(String category) {
        return productRepo.findByCategory(category);
    }

    public List<Products> getProductsByPriceRange(double min, double max) {
        return productRepo.findByPriceBetween(min, max);
    }
}
