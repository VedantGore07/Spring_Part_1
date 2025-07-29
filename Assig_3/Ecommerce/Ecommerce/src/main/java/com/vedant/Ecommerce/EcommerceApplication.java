package com.vedant.Ecommerce;

import com.vedant.Ecommerce.beans.Category;
import com.vedant.Ecommerce.beans.Product;
import com.vedant.Ecommerce.beans.User;

import com.vedant.Ecommerce.beans.Order;
import com.vedant.Ecommerce.services.CategoryService;
import com.vedant.Ecommerce.services.OrderService;
import com.vedant.Ecommerce.services.ProductService;
import com.vedant.Ecommerce.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class EcommerceApplication implements CommandLineRunner {

	@Autowired
	private UserService userService;

	@Autowired
	private OrderService orderService;

	@Autowired
	private ProductService productService;

	@Autowired
	private CategoryService categoryService;

	public static void main(String[] args) {
		SpringApplication.run(EcommerceApplication.class, args);
	}

	@Override
	public void run(String... args) {
		Scanner scanner = new Scanner(System.in);
		boolean exit = false;

		while (!exit) {
			System.out.println("\n====== E-Commerce Console App ======");
			System.out.println("1. Create User + Profile");
			System.out.println("2. Create Category");
			System.out.println("3. Create Product");
			System.out.println("4. Assign Categories to Product");
			System.out.println("5. Create Order for User with Products");
			System.out.println("6. Fetch User with Profile and Orders");
			System.out.println("7. Fetch Product with Categories");
			System.out.println("8. Fetch All Products in a Category");
			System.out.println("9. Update User");
			System.out.println("10. Delete User");
			System.out.println("11. Update Product");
			System.out.println("12. Delete Product");
			System.out.println("13. Update Category");
			System.out.println("14. Delete Category");
			System.out.println("15. Delete Order");
			System.out.println("0. Exit");
			System.out.print("Enter Choice: ");
			int choice = scanner.nextInt();
			scanner.nextLine();

			switch (choice) {
				case 1 -> {
					System.out.print("Username: ");
					String uname = scanner.nextLine();
					System.out.print("Password: ");
					String pwd = scanner.nextLine();
					System.out.print("First Name: ");
					String fname = scanner.nextLine();
					System.out.print("Last Name: ");
					String lname = scanner.nextLine();
					System.out.print("Email: ");
					String email = scanner.nextLine();
					User user = userService.createUserWithProfile(uname, pwd, fname, lname, email);
					System.out.println("User created with ID: " + user.getUserId());
				}
				case 2 -> {
					System.out.print("Category Name: ");
					String catName = scanner.nextLine();
					Category cat = categoryService.createCategory(catName);
					System.out.println("Category created with ID: " + cat.getCategoryId());
				}
				case 3 -> {
					System.out.print("Product Name: ");
					String pname = scanner.nextLine();
					System.out.print("Price: ");
					double price = scanner.nextDouble();
					scanner.nextLine();
					Product product = productService.createProduct(pname, price);
					System.out.println("Product created with ID: " + product.getId());
				}
				case 4 -> {
					System.out.print("Enter Product ID: ");
					int prodId = scanner.nextInt();
					scanner.nextLine();
					System.out.print("Enter Category IDs (comma-separated): ");
					String[] catIdsStr = scanner.nextLine().split(",");
					List<Integer> catIds = Arrays.stream(catIdsStr)
							.map(String::trim)
							.map(Integer::parseInt)
							.toList();
					Product updated = productService.assignCategoriesToProduct(prodId, catIds);
					System.out.println("Categories assigned to product: " + updated.getProductName());
				}
				case 5 -> {
					System.out.print("Enter User ID: ");
					int userId = scanner.nextInt();
					scanner.nextLine();
					System.out.print("Enter Product IDs (comma-separated): ");
					String[] prodIdsStr = scanner.nextLine().split(",");
					List<Integer> prodIds = Arrays.stream(prodIdsStr)
							.map(String::trim)
							.map(Integer::parseInt)
							.toList();
					Order order = orderService.createOrderForUser(userId, prodIds);
					if (order != null)
						System.out.println("Order created with ID: " + order.getOrderId());
					else
						System.out.println("Failed to create order. User might not exist.");
				}
				case 6 -> {
					System.out.print("Enter User ID: ");
					int userId = scanner.nextInt();
					scanner.nextLine();

					User user = userService.fetchUserWithProfileAndOrders(userId);
					if (user != null) {
						System.out.println("User: " + user.getUsername());
						if (user.getProfile() != null) {
							System.out.println("Profile Email: " + user.getProfile().getEmail());
							System.out.println("Name: " + user.getProfile().getFirstName() + " " + user.getProfile().getLastName());
						}
						System.out.println("Orders:");
						for (Order o : user.getOrders()) {
							System.out.println(" - Order ID: " + o.getOrderId() + ", Date: " + o.getOrderDate());
							for (Product p : o.getProducts()) {
								System.out.println("    → Product: " + p.getProductName() + ", Price: " + p.getProductPrice());
							}
						}
					} else {
						System.out.println("User not found.");
					}
				}
				case 7 -> {
					System.out.print("Enter Product ID: ");
					int prodId = scanner.nextInt();
					scanner.nextLine();

					Product prod = productService.fetchProductWithCategories(prodId);
					if (prod != null) {
						System.out.println("Product: " + prod.getProductName() + " | Price: " + prod.getProductPrice());
						System.out.println("Categories:");
						for (Category cat : prod.getCategories()) {
							System.out.println(" - " + cat.getCategoryName());
						}
					} else {
						System.out.println("Product not found.");
					}
				}
				case 8 -> {
					System.out.print("Enter Category ID: ");
					int catId = scanner.nextInt();
					List<Product> products = productService.fetchAllProductsByCategory(catId);
					System.out.println("Products in Category:");
					for (Product p : products) {
						System.out.println(p.getProductName());
					}
				}
				case 9 -> {
					System.out.print("User ID: ");
					int uid = scanner.nextInt(); scanner.nextLine();
					System.out.print("New Username: ");
					String username = scanner.nextLine();
					System.out.print("New Password: ");
					String password = scanner.nextLine();
					User updated = userService.updateUser(uid, username, password);
					if (updated != null)
						System.out.println("User updated: " + updated.getUsername());
					else
						System.out.println("User not found.");
				}
				case 10 -> {
					System.out.print("User ID to delete: ");
					int id = scanner.nextInt();
					userService.deleteUser(id);
					System.out.println("User deleted.");
				}
				case 11 -> {
					System.out.print("Product ID: ");
					int pid = scanner.nextInt(); scanner.nextLine();
					System.out.print("New Name: ");
					String name = scanner.nextLine();
					System.out.print("New Price: ");
					double price = scanner.nextDouble(); scanner.nextLine();
					Product updated = productService.updateProduct(pid, name, price);
					if (updated != null)
						System.out.println("Product updated.");
					else
						System.out.println("Product not found.");
				}
				case 12 -> {
					System.out.print("Product ID to delete: ");
					int id = scanner.nextInt();
					productService.deleteProduct(id);
					System.out.println("Product deleted.");
				}
				case 13 -> {
					System.out.print("Category ID: ");
					int id = scanner.nextInt(); scanner.nextLine();
					System.out.print("New Name: ");
					String name = scanner.nextLine();
					Category updated = categoryService.updateCategory(id, name);
					if (updated != null)
						System.out.println("Category updated.");
					else
						System.out.println("Category not found.");
				}
				case 14 -> {
					System.out.print("Category ID to delete: ");
					int id = scanner.nextInt();
					categoryService.deleteCategory(id);
					System.out.println("Category deleted.");
				}
				case 15 -> {
					System.out.print("Order ID to delete: ");
					int id = scanner.nextInt();
					orderService.deleteOrder(id);
					System.out.println("Order deleted.");
				}
				case 0 -> {
					exit = true;
					System.out.println("Exiting...");
				}
				default -> System.out.println("Invalid choice.");
			}
		}

		scanner.close();
	}
}
