package com.vedant.inventoryManagement;

import com.vedant.inventoryManagement.beans.Products;
import com.vedant.inventoryManagement.services.ProductServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

@SpringBootApplication
public class InventoryManagementApplication implements CommandLineRunner {

	@Autowired
	ProductServices productServices;

	@Value("${spring.application.name}")
	private String appName;

	public static void main(String[] args) {
		SpringApplication.run(InventoryManagementApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Scanner scanner = new Scanner(System.in);

		System.out.println(appName);
		System.out.println("Enter 1 to add new Product");
		System.out.println("Enter 2 to add multiple Product");
		System.out.println("Enter 3 to find the Product on basis of id");
		System.out.println("Enter 4 to update Product details");
		System.out.println("Enter 5 to remove Product");
		System.out.println("Enter 6 to view all Product");
		System.out.println("Enter 7 to view category to search ");
		System.out.println("Enter 8 to view min-max price");
		System.out.println("Enter your choice : ");

		int operation = scanner.nextInt();

		switch (operation)
		{
			case 1:

				System.out.println("Enter Product Name");
				String productName = scanner.next();
				System.out.println("Enter Product Description");
				String productDescription = scanner.next();
				System.out.println("Enter Product Price");
				double productPrice = scanner.nextDouble();
				System.out.println("Enter Product Stock Quantity");
				int stockQuantity = scanner.nextInt();
				System.out.println("Enter Product category");
				String category=scanner.next();

				Products product1 = new Products();
				product1.setName(productName);
				product1.setDescription(productDescription);
				product1.setPrice(productPrice);
				product1.setStockQuantity(stockQuantity);
				product1.setCategory(category);

				productServices.addProduct(product1);
				break;

			case 2:
				System.out.println("How many Product do you want to add?");
				int noOfProducts = scanner.nextInt();
				List<Products> ProductsList = new ArrayList<>();
				for (int i = 0; i < noOfProducts; i++) {
					System.out.println("Enter Product Name");
					String productName1 = scanner.next();
					System.out.println("Enter product Description ");
					String productDescription1 = scanner.next();
					System.out.println("Enter product price");
					double productPrice1 = scanner.nextDouble();
					System.out.println("Enter product StockQuantity");
					int ProductStockQuantity1 = scanner.nextInt();
					System.out.println("Enter Product category");
					String category1=scanner.next();
					Products product2 = new Products();
					product2.setName(productName1);
					product2.setDescription(productDescription1);
					product2.setPrice(productPrice1);
					product2.setStockQuantity(ProductStockQuantity1);
					product2.setCategory(category1);

					ProductsList.add(product2);
				}
				productServices.addMultipleProducts(ProductsList);
				break;

			case 3:
				System.out.println("Enter ProductID to see Product details");
				int productId = scanner.nextInt();
				try {
					Optional<Products> optional = productServices.getProductById(productId);
					Products products = optional.get();
					System.out.println(products.toString());
				} catch (Exception e) {
					System.err.println("Id not found");
				}
				break;

			case 4:
				System.out.println("Enter ProductId to update: ");
				int updateId = scanner.nextInt();
				Optional<Products> optionalProducts = productServices.getProductById(updateId);
				if (optionalProducts.isPresent()) {
					Products existingProduct = optionalProducts.get();
					System.out.println("Existing Details:");
					System.out.println("ProductName: " + existingProduct.getName());
					System.out.println("ProductDescription: " + existingProduct.getDescription());
					System.out.println("ProductPrice: " + existingProduct.getPrice());
					System.out.println("ProductStockQuantity:" + existingProduct.getStockQuantity());

					System.out.println("Enter new ProductName: ");
					String newName = scanner.next();
					System.out.println("Enter new ProductDescription: ");
					String newDescription = scanner.next();
					System.out.println("Enter new ProductPrice: ");
					double newPrice = scanner.nextDouble();
					System.out.println("Enter new ProductStockQuantity: ");
					int newStockQuantity = scanner.nextInt();

					existingProduct.setName(newName);
					existingProduct.setDescription(newDescription);
					existingProduct.setPrice(newPrice);
					existingProduct.setStockQuantity(newStockQuantity);

					productServices.updateProduct(existingProduct);
					System.out.println("product updated successfully.");
				}else {
					System.out.println("Product not found with ID: " + updateId);
				}
				break;

			case 5:
				System.out.println("Enter Product ID to delete: ");
				int deleteId = scanner.nextInt();
				try {
					productServices.deleteProduct(deleteId);
					System.out.println("Product deleted successfully.");
				} catch (Exception e) {
					System.out.println("Failed to delete. ID may not exist.");
				}
				break;

			case 6:
				List<Products> allProducts = productServices.getAllProducts();
				if (allProducts.isEmpty()) {
					System.out.println("No Products found.");
				} else {
					System.out.println("All Products: ");
					for (Products p : allProducts) {
						System.out.println(p);
					}
				}
				break;

			case 7:
				System.out.println("Enter category to search: ");
				String category2 = scanner.next();
				List<Products> byCategory = productServices.getProductsByCategory(category2);
				if (byCategory.isEmpty()) {
					System.out.println("No products found in this category.");
				} else {
					byCategory.forEach(System.out::println);
				}
				break;

			case 8:
				System.out.println("Enter min price:");
				double min = scanner.nextDouble();
				System.out.println("Enter max price:");
				double max = scanner.nextDouble();
				List<Products> byPrice = productServices.getProductsByPriceRange(min, max);
				byPrice.forEach(System.out::println);
				break;

			default:
				System.out.println("please select valid operation. Thank you!");

		}

	}
}
