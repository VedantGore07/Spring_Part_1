package com.vedant.LibraryManagement_Mapping.services;

import com.vedant.LibraryManagement_Mapping.beans.Author;

import java.util.List;
import java.util.Optional;

public interface AuthorServiceInterface {

    List<Author> findAll();
    void addAuthor(Author author);
    Optional<Author> findById(int id);
    void deleteAuthor(int id);

}
