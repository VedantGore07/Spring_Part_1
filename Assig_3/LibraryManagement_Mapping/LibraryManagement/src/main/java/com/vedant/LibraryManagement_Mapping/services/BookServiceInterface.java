package com.vedant.LibraryManagement_Mapping.services;

import com.vedant.LibraryManagement_Mapping.beans.Book;

import java.util.List;
import java.util.Optional;

public interface BookServiceInterface {

    void addBook(Book book);
    void addAuthorToBook(int bookId, int authorId);
    void addbranchToBook(int bookId, int branchId);
    List<Book> findAll();
    Optional<Book> findById(int id);
    void deleteById(int id);

}
