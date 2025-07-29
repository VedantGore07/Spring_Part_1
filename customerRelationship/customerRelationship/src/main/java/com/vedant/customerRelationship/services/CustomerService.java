package com.vedant.customerRelationship.services;

import com.vedant.customerRelationship.beans.Customer;
import com.vedant.customerRelationship.beans.Interaction;
import com.vedant.customerRelationship.repos.CustomerRepo;
import com.vedant.customerRelationship.repos.InteractionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CustomerService implements CustomerServiceInterface{

    @Autowired
    CustomerRepo customerRepo;
    @Autowired
    InteractionRepo interactionRepo;

    @Override
    public void addCustomer(Customer customer) {
        customerRepo.save(customer);
    }

    @Override
    public void addInteraction(Integer customerId, Interaction interaction) {
        Optional<Customer> customer = customerRepo.findById(customerId);
        if (customer.isPresent()) {
            customer.get().getInteractions().add(interaction);
            customerRepo.save(customer.get());
        }
        else {
            System.out.println("Customer not found");
        }
    }

    @Override
    public Customer getCustomerById(Integer customerId) {
        return customerRepo.findById(customerId).get();
    }

    @Override
    public List<Interaction> getInteractionsByCustomerId(Integer customerId) {
        return customerRepo.findById(customerId).get().getInteractions();
    }

    @Override
    public void updateCustomerPhone(Integer customerId, String phoneNumber) {
        Customer customer = customerRepo.findById(customerId).get();
        customer.setCustomerPhone(phoneNumber);
        customerRepo.save(customer);
    }

    @Override
    public void updateInteractionProduct(Integer interactionId, String productName) {
        Interaction interaction = interactionRepo.findById(interactionId).get();
        interaction.setInteractionProduct(productName);
        interactionRepo.save(interaction);
    }

    @Override
    public void deleteInactiveCustomer() {
        List<Customer> allCustomers = customerRepo.findAll();

        List<Customer> inactiveCustomers = allCustomers.stream()
                .filter(customer -> customer.getInteractions() == null || customer.getInteractions().isEmpty())
                .collect(Collectors.toList());

        customerRepo.deleteAll(inactiveCustomers);
    }

    @Override
    public List<Interaction> getInteractionByProduct(String product) {
        return interactionRepo.findByInteractionProduct(product);
    }

    @Override
    public List<Interaction> getInteractionBetweenDates(String startDate, String endDate) {
        return interactionRepo.findByInteractionDateBetween(startDate, endDate);
    }

    @Override
    public List<Interaction> getInteractionByRating(Integer rating) {
        return interactionRepo.findByInteractionRating(rating);
    }
}
