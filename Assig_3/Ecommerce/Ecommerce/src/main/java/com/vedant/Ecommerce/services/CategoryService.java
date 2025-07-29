package com.vedant.Ecommerce.services;

import com.vedant.Ecommerce.beans.Category;
import com.vedant.Ecommerce.repos.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CategoryService implements CategoryServiceInterface{

    @Autowired
    private CategoryRepo categoryRepo;

    @Override
    public Category createCategory(String name) {
        Category category = new Category();
        category.setCategoryName(name);
        return categoryRepo.save(category);
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryRepo.findAll();
    }

    @Override
    public Category updateCategory(int id, String newName) {
        Category category = categoryRepo.findById(id).orElse(null);
        if (category != null) {
            category.setCategoryName(newName);
            return categoryRepo.save(category);
        }
        return null;
    }

    @Override
    public void deleteCategory(int id) {
        categoryRepo.deleteById(id);
    }

}
