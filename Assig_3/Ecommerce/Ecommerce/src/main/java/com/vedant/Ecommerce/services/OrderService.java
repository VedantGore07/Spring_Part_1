package com.vedant.Ecommerce.services;

import com.vedant.Ecommerce.beans.Order;
import com.vedant.Ecommerce.beans.User;
import com.vedant.Ecommerce.beans.Product;
import com.vedant.Ecommerce.repos.OrderRepo;
import com.vedant.Ecommerce.repos.UserRepo;
import com.vedant.Ecommerce.repos.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class OrderService implements OrderServiceInterface{

    @Autowired
    private OrderRepo orderRepo;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private ProductRepo productRepo;

    @Override
    public Order createOrderForUser(int userId, List<Integer> productIds) {
        User user = userRepo.findById(userId).orElse(null);
        if (user == null) return null;

        List<Product> products = productRepo.findAllById(productIds);

        Order order = new Order();
        order.setOrderDate(LocalDate.now());
        order.setUser(user);
        order.setProducts(products);

        return orderRepo.save(order);
    }

    @Override
    public void deleteOrder(int id) {
        orderRepo.deleteById(id);
    }

}
