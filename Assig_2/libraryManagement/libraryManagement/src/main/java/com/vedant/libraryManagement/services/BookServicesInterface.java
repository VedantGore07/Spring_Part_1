package com.vedant.libraryManagement.services;

import com.vedant.libraryManagement.beans.Books;

import java.util.List;
import java.util.Optional;

public interface BookServicesInterface {

    void addBooks(Books books);
    Optional<Books> FindBookById(int Id);
    void updateBook(Books books);
    void deleteBook(int BookId);
    List<Books> getBooksByAuthor(String author);
    List<Books> getBooksByGenre(String genre);
    List<Books> getBooksAfterYear(int year);

}
