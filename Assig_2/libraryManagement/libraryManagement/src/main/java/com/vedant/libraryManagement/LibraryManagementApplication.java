package com.vedant.libraryManagement;

import com.vedant.libraryManagement.beans.Books;
import com.vedant.libraryManagement.services.BookServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

@SpringBootApplication
public class LibraryManagementApplication implements CommandLineRunner {

	@Autowired
	BookServices bookservices;

	public static void main(String[] args) {
		SpringApplication.run(LibraryManagementApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter 1 to add new Book");
		System.out.println("Enter 2 to find the Book on basis of id");
		System.out.println("Enter 3 to update Book details");
		System.out.println("Enter 4 to remove Book");
		System.out.println("Enter 5 Fetch Book by Author");
		System.out.println("Enter 6 Fetch Book by genre");
		System.out.println("Enter 7 Fetch Book by publicationYear");
		System.out.println("Enter your choice :-");

		int Operation = scanner.nextInt();
		switch (Operation) {
			case 1:
				System.out.println("Enter Book Title: ");
				String bookTitle = scanner.next();
				System.out.println("Enter Book Author: ");
				String bookAuthor = scanner.next();
				System.out.println("Enter Book ISBN: ");
				String bookIsbn = scanner.next();
				System.out.println("Enter Publication Year: ");
				int publicationYear = scanner.nextInt();
				System.out.println("Enter Book Genre: ");
				String genre = scanner.next();
				Books book1 = new Books();
				book1.setTitle(bookTitle);
				book1.setAuthor(bookAuthor);
				book1.setIsbn(bookIsbn);
				book1.setPublicationYear(publicationYear);
				book1.setGenre(genre);

				bookservices.addBooks(book1);
				break;

			case 2:
				System.out.println("Enter BookID to see Books details");
				int Id = scanner.nextInt();
				try {
					Optional<Books> optional = bookservices.FindBookById(Id);
					Books books = optional.get();
					System.out.println(books.toString());
				} catch (Exception e) {
					System.err.println("Id not found");
				}
				break;


			case 3:
				System.out.println("Enter BookId to update:");
				int updateId = scanner.nextInt();
				Optional<Books> optionalBooks = bookservices.FindBookById(updateId);
				if (optionalBooks.isPresent()) {
					Books existingBooks = optionalBooks.get();
					System.out.println("Existing Details:");
					System.out.println("Book Title: " + existingBooks.getTitle());
					System.out.println("Book Author: " + existingBooks.getAuthor());
					System.out.println("Book ISBN:" + existingBooks.getIsbn());
					System.out.println("Publication Year:" + existingBooks.getPublicationYear());
					System.out.println("Book Genre:" + existingBooks.getGenre());

					System.out.println("Enter Book Title");
					String newTitle = scanner.next();
					System.out.println("Enter Book Author ");
					String newAuthor = scanner.next();
					System.out.println("Enter Book ISBN:");
					String newIsbn = scanner.next();
					System.out.println("Enter Publication Year");
					int newPublication = scanner.nextInt();
					System.out.println("Enter Book Genre:");
					String newGenre =scanner.next();
					existingBooks.setTitle(newTitle);
					existingBooks.setAuthor(newAuthor);
					existingBooks.setIsbn(newIsbn);
					existingBooks.setPublicationYear(newPublication);
					existingBooks.setGenre(newGenre);
					bookservices.updateBook(existingBooks);
					System.out.println("Books updated successfully.");
				}else {
					System.out.println("Books not found with ID: " + updateId);
				}
				break;

			case 4:
				System.out.println("Enter Book ID to delete:");
				int deleteId = scanner.nextInt();
				try {
					bookservices.deleteBook(deleteId);
					System.out.println("book deleted successfully.");
				} catch (Exception e) {
					System.out.println("Failed to delete. ID may not exist.");
				}
				break;


			case 5:
				System.out.println("Enter Author Name: ");
				String author = scanner.next();
				List<Books> authorBooks = bookservices.getBooksByAuthor(author);
				if (authorBooks.isEmpty()) {
					System.out.println("No books found by author: " + author);
				} else {
					authorBooks.forEach(System.out::println);
				}
				break;

			case 6:
				System.out.println("Enter Genre: ");
				String genres = scanner.next();
				List<Books> genreBooks = bookservices.getBooksByGenre(genres);
				if (genreBooks.isEmpty()) {
					System.out.println("No books found in genre: " + genres);
				} else {
					genreBooks.forEach(System.out::println);
				}
				break;
			case 7:
				System.out.println("Enter Year: ");
				int year = scanner.nextInt();
				List<Books> recentBooks = bookservices.getBooksAfterYear(year);
				if (recentBooks.isEmpty()) {
					System.out.println("No books found published after year: " + year);
				} else {
					recentBooks.forEach(System.out::println);
				}
				break;
			default:
				System.out.println("Please select valid operation. Thank you!");


		}
	}
}
