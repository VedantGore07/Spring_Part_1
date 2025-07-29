package com.vedant.Ecommerce.services;

import com.vedant.Ecommerce.beans.Profile;
import com.vedant.Ecommerce.beans.User;
import com.vedant.Ecommerce.repos.ProfileRepo;
import com.vedant.Ecommerce.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService implements UserServiceInterface{

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private ProfileRepo profileRepo;

    @Override
    public User createUserWithProfile(String username, String password, String fname, String lname, String email) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);

        Profile profile = new Profile();
        profile.setFirstName(fname);
        profile.setLastName(lname);
        profile.setEmail(email);
        profile.setUser(user);
        user.setProfile(profile);

        return userRepo.save(user);
    }

    @Override
    @Transactional(readOnly = true)
    public User fetchUserWithProfileAndOrders(int userId) {
        User user = userRepo.findById(userId).orElse(null);
        if (user != null) {
            if (user.getProfile() != null) {
                user.getProfile().getEmail();
            }
            user.getOrders().forEach(order -> {
                order.getProducts().size();
            });
        }
        return user;
    }

    @Override
    public User updateUser(int id, String username, String password) {
        User user = userRepo.findById(id).orElse(null);
        if (user != null) {
            user.setUsername(username);
            user.setPassword(password);
            return userRepo.save(user);
        }
        return null;
    }

    @Override
    public void deleteUser(int id) {
        userRepo.deleteById(id);
    }

}
