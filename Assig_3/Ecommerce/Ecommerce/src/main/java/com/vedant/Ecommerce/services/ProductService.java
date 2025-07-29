package com.vedant.Ecommerce.services;

import com.vedant.Ecommerce.beans.Category;
import com.vedant.Ecommerce.beans.Product;
import com.vedant.Ecommerce.repos.CategoryRepo;
import com.vedant.Ecommerce.repos.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class ProductService implements ProductServiceInterface{

    @Autowired
    private ProductRepo productRepo;

    @Autowired
    private CategoryRepo categoryRepo;

    @Override
    public Product createProduct(String name, double price) {
        Product product = new Product();
        product.setProductName(name);
        product.setProductPrice(price);
        return productRepo.save(product);
    }

    @Override
    public Product assignCategoriesToProduct(int productId, List<Integer> categoryIds) {
        Product product = productRepo.findById(productId).orElse(null);
        if (product == null) return null;

        List<Category> categories = categoryRepo.findAllById(categoryIds);
        product.setCategories(categories);
        return productRepo.save(product);
    }

    @Override
    @Transactional(readOnly = true)
    public Product fetchProductWithCategories(int productId) {
        Product product = productRepo.findById(productId).orElse(null);
        if (product != null) {
            product.getCategories().size();
        }
        return product;
    }

    @Override
    public List<Product> fetchAllProductsByCategory(int categoryId) {
        return productRepo.findByCategories_CategoryId(categoryId);
    }

    @Override
    public Product updateProduct(int id, String name, double price) {
        Product product = productRepo.findById(id).orElse(null);
        if (product != null) {
            product.setProductName(name);
            product.setProductPrice(price);
            return productRepo.save(product);
        }
        return null;
    }

    @Override
    public void deleteProduct(int id) {
        productRepo.deleteById(id);
    }

}
