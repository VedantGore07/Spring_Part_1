package com.vedant.Ecommerce.services;

import com.vedant.Ecommerce.beans.Category;

import java.util.List;

public interface CategoryServiceInterface {

    Category createCategory(String name);
    List<Category> getAllCategories();
    Category updateCategory(int id, String newName);
    void deleteCategory(int id);

}
