package com.vedant.Ecommerce.services;

import com.vedant.Ecommerce.beans.Order;

import java.util.List;

public interface OrderServiceInterface {

    Order createOrderForUser(int userId, List<Integer> productIds);

    void deleteOrder(int id);

}
