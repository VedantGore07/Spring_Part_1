package com.vedant.customerRelation;

import com.vedant.customerRelation.beans.Customer;
import com.vedant.customerRelation.beans.Interaction;
import com.vedant.customerRelation.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class CustomerRelationApplication implements CommandLineRunner {

	@Autowired
	CustomerService customerService;

	public static void main(String[] args) {
		SpringApplication.run(CustomerRelationApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Scanner scanner = new Scanner(System.in);
		String customerName, customerEmail, customerPhone, customerAddress, interactionFeedback, interactionDate, interactionProduct;
		Integer customerId, interactionId, interactionRating;
		List<Interaction> interactions;
		Customer customer;
		Interaction interaction;

		while (true) {
			System.out.println("\n===== CRM Menu =====");
			System.out.println("Enter 1 to add customer");
			System.out.println("Enter 2 to add interaction for Customer");
			System.out.println("Enter 3 to get customer by id");
			System.out.println("Enter 4 to get interaction for Customer");
			System.out.println("Enter 5 to update Customer phone number");
			System.out.println("Enter 6 to update interaction product name");
			System.out.println("Enter 7 to delete Inactive Customer");
			System.out.println("Enter 8 to get feedback for product");
			System.out.println("Enter 9 to get Interaction between dates");
			System.out.println("Enter 10 to get interaction by ratings");
			System.out.println("Enter 11 to Exit");

			System.out.print("Choose an option: ");
			Integer operation = scanner.nextInt();

			switch (operation) {
				case 1:
					System.out.println("Enter customer name");
					customerName = scanner.next();
					System.out.println("Enter customer email");
					customerEmail = scanner.next();
					System.out.println("Enter customer phone");
					customerPhone = scanner.next();
					System.out.println("Enter customer address");
					customerAddress = scanner.next();

					customer = new Customer(customerName, customerEmail, customerPhone, customerAddress);
					customerService.addCustomer(customer);
					break;

				case 2:
					System.out.println("Enter customer ID to add interaction for Customer");
					customerId = scanner.nextInt();
					System.out.println("Enter feedback");
					interactionFeedback = scanner.next();
					System.out.println("Enter date");
					interactionDate = scanner.next();
					System.out.println("Enter product");
					interactionProduct = scanner.next();
					System.out.println("Enter rating");
					interactionRating = scanner.nextInt();

					interaction = new Interaction(interactionDate, interactionFeedback, interactionRating, interactionProduct);
					customerService.addInteraction(customerId, interaction);
					break;

				case 3:
					System.out.println("Enter customer ID to fetch information");
					customerId = scanner.nextInt();
					customer = customerService.getCustomerById(customerId);
					System.out.println(customer);
					break;

				case 4:
					System.out.println("Enter customer id to get all interactions");
					customerId = scanner.nextInt();
					interactions = customerService.getInteractionsByCustomerId(customerId);
					interactions.forEach(System.out::println);
					break;

				case 5:
					System.out.println("Enter Customer ID to update phone number");
					customerId = scanner.nextInt();
					System.out.println("Enter Customer new phone number");
					customerPhone = scanner.next();
					customerService.updateCustomerPhone(customerId, customerPhone);
					break;

				case 6:
					System.out.println("Enter Interaction Id to update product");
					interactionId = scanner.nextInt();
					System.out.println("Enter new product");
					interactionProduct = scanner.next();
					customerService.updateInteractionProduct(interactionId, interactionProduct);
					break;

				case 7:
					customerService.deleteInactiveCustomer();
					break;

				case 8:
					System.out.println("Enter the product to get feedbacks for product");
					interactionProduct = scanner.next();
					interactions = customerService.getInteractionByProduct(interactionProduct);
					interactions.forEach(i -> System.out.println("Feedback for product is: " + i.getInteractionFeedback()));
					break;

				case 9:
					System.out.println("Enter Starting Date");
					String startDate = scanner.next();
					System.out.println("Enter Ending Date");
					String endDate = scanner.next();
					interactions = customerService.getInteractionBetweenDates(startDate, endDate);
					interactions.forEach(System.out::println);
					break;

				case 10:
					System.out.println("Enter rating to search for interaction");
					interactionRating = scanner.nextInt();
					interactions = customerService.getInteractionByRating(interactionRating);
					interactions.forEach(System.out::println);
					break;

				case 11:
					System.out.println("Exiting CRM system!");
					System.exit(0);
					break;

				default:
					System.out.println("Invalid option. Please try again.");
			}
		}

	}
}
