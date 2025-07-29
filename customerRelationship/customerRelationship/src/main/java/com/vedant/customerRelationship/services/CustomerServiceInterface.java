package com.vedant.customerRelationship.services;

import com.vedant.customerRelationship.beans.Customer;
import com.vedant.customerRelationship.beans.Interaction;

import java.util.List;

public interface CustomerServiceInterface {

    public void addCustomer(Customer customer);
    public void addInteraction(Integer customerId, Interaction interaction);
    public Customer getCustomerById(Integer customerId);
    public List<Interaction> getInteractionsByCustomerId(Integer customerId);
    public void updateCustomerPhone(Integer customerId, String phone);
    public void updateInteractionProduct(Integer interactionId, String product);
    public void deleteInactiveCustomer();
    public List<Interaction> getInteractionByProduct(String product);
    public List<Interaction> getInteractionBetweenDates(String startDate, String endDate);
    public List<Interaction> getInteractionByRating(Integer rating);
}
