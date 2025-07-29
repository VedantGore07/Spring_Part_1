package com.vedant.Ecommerce.services;

import com.vedant.Ecommerce.beans.Profile;
import com.vedant.Ecommerce.beans.User;

public interface UserServiceInterface {

    User createUserWithProfile(String username, String password, String fname, String lname, String email);
    User fetchUserWithProfileAndOrders(int userId);
    User updateUser(int id, String username, String password);
    void deleteUser(int id);

}