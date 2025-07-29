package com.vedant.Ecommerce.services;

import com.vedant.Ecommerce.beans.Product;

import java.util.List;

public interface ProductServiceInterface {

    Product createProduct(String name, double price);
    Product assignCategoriesToProduct(int productId, List<Integer> categoryIds);
    Product fetchProductWithCategories(int productId);
    List<Product> fetchAllProductsByCategory(int categoryId);
    Product updateProduct(int id, String name, double price);
    void deleteProduct(int id);


}