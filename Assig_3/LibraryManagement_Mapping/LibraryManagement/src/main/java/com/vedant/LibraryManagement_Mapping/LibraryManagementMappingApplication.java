package com.vedant.LibraryManagement_Mapping;

import com.vedant.LibraryManagement_Mapping.beans.Author;
import com.vedant.LibraryManagement_Mapping.beans.Book;
import com.vedant.LibraryManagement_Mapping.beans.LibraryBranch;
import com.vedant.LibraryManagement_Mapping.beans.Publisher;
import com.vedant.LibraryManagement_Mapping.services.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.*;

@SpringBootApplication
public class LibraryManagementMappingApplication implements CommandLineRunner {

	@Autowired
	BookService bookService;

	@Autowired
	AuthorService authorService;

	@Autowired
	PublisherService publisherService;

	@Autowired
	LibraryBranchService libraryBranchService;

	public static void main(String[] args) {
		SpringApplication.run(LibraryManagementMappingApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Scanner sc = new Scanner(System.in);

		outter:
		while (true) {
			System.out.println("\n==== LibraryManagement Console ====");
			System.out.println("1. Add Book");
			System.out.println("2. Get All Books");
			System.out.println("3. Delete Book by ID");
			System.out.println("4. Add Author");
			System.out.println("5. Get All Authors");
			System.out.println("6. Delete Author by ID");
			System.out.println("7. Add Publisher");
			System.out.println("8. Get All Publishers");
			System.out.println("9. Delete Publisher by ID");
			System.out.println("10. Add Library Branch");
			System.out.println("11. Get All Library Branches");
			System.out.println("12. Delete Library Branch by ID");
			System.out.println("13. Add Author to Book");
			System.out.println("14. Add Library Branch to Book");

			System.out.println("Enter any other number to exit.");
			System.out.print("Enter your choice: ");

			int choice = sc.nextInt();
			sc.nextLine();

			switch (choice) {
				case 1: {
					System.out.println("Enter Book Title: ");
					String bookTitle = sc.nextLine();
					System.out.println("Enter Author Id: ");
					int authorId = sc.nextInt();
					System.out.println("Enter Publisher Id: ");
					int publisherId = sc.nextInt();
					System.out.println("Enter Library Branch Id: ");
					int libraryBranchId = sc.nextInt();

					Optional<Author> a = authorService.findById(authorId);
					Optional<Publisher> p = publisherService.findById(publisherId);
					Optional<LibraryBranch> l = libraryBranchService.findById(libraryBranchId);


					if (a.isEmpty() || p.isEmpty() || l.isEmpty()) {
						System.out.println("Invalid Input");
						break;
					}

					Book book = new Book(bookTitle, p.get(), a.get(), l.get());
					bookService.addBook(book);
					System.out.println("Book added");

					break;
				}
				case 2:{
					System.out.println(bookService.findAll());
					break;
				}
				case 3:{
					System.out.println("Enter Book Id: ");
					int bookId = sc.nextInt();
					bookService.deleteById(bookId);
					System.out.println("Book Deleted");
					break;
				}
				case 4:{
					System.out.println("Enter Author Name: ");
					String authorName = sc.nextLine();
					Author author = new Author(authorName);
					authorService.addAuthor(author);
					System.out.println("Author added :"+ author);

					break;
				}
				case 5: {
					System.out.println(authorService.findAll());
					break;
				}
				case 6:{
					System.out.println("Enter Author Id: ");
					int authorId = sc.nextInt();
					authorService.deleteAuthor(authorId);
					System.out.println("Author Deleted");
					break;
				}
				case 7:{
					System.out.println("Enter Publisher Name: ");
					String publisherName = sc.nextLine();
					Publisher publisher = new Publisher(publisherName);
					publisherService.addPublisher(publisher);
					System.out.println("Publisher added :"+ publisher);
					break;}
				case 8:{
					System.out.println(publisherService.findAll());
					break;
				}
				case 9:{
					System.out.println("Enter Publisher Id: ");
					int publisherId = sc.nextInt();
					publisherService.deletePublisher(publisherId);
					System.out.println("Publisher Deleted");
					break;
				}
				case 10: {
					System.out.println("Enter Library Branch Name: ");
					String libraryBranchName = sc.nextLine();
					System.out.println("Enter Library Branch Location: ");
					String libraryBranchLocation = sc.nextLine();
					LibraryBranch libraryBranch = new LibraryBranch(libraryBranchName, libraryBranchLocation);
					libraryBranchService.addLibraryBranch(libraryBranch);
					System.out.println("Library Branch added :" + libraryBranch);
					break;
				}
				case 11:{
					System.out.println(libraryBranchService.findAll());
					break;
				}
				case 12:{
					System.out.println("Getting Library Branch Id :");
					int libraryBranchId = sc.nextInt();
					libraryBranchService.deleteLibraryBranch(libraryBranchId);
					System.out.println("Library Branch Deleted");
					break;
				}
				case 13:{
					System.out.println("Enter Book Id");
					int bookId = sc.nextInt();
					System.out.println("Enter Author Id");
					int authorId = sc.nextInt();

					try{
						bookService.addAuthorToBook(bookId, authorId);
						System.out.println("Author added");
					}catch(Exception e){
						System.out.println("Error Occurred " + e.toString());
					}


					break;
				}
				case 14:{
					System.out.println("Enter Book Id");
					int bookId = sc.nextInt();
					System.out.println("Enter Library Branch Id");
					int branchId = sc.nextInt();
					Optional<LibraryBranch> a = libraryBranchService.findById(branchId);
					Optional<Book> b = bookService.findById(bookId);
					if (b.isEmpty() || a.isEmpty()) {
						System.out.println("Invalid Input");
						break;
					}

					Book book = b.get();
					book.addBranch(a.get());
					bookService.addBook(book);

					System.out.println("Branch added");
				}
				default:
					System.out.println("Exiting program.");
					sc.close();
					break outter;
			}
		}
	}
}
