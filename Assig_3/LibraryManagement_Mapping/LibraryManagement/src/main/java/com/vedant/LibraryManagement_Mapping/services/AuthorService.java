package com.vedant.LibraryManagement_Mapping.services;

import com.vedant.LibraryManagement_Mapping.beans.Author;
import com.vedant.LibraryManagement_Mapping.repos.AuthorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class AuthorService implements AuthorServiceInterface {

    @Autowired
    AuthorRepo authorRepo;

    @Override
    public List<Author> findAll() {
        return authorRepo.findAll();
    }

    @Override
    public void addAuthor(Author author) {
        authorRepo.save(author);
    }

    @Override
    public Optional<Author> findById(int id) {
        return authorRepo.findById(id);
    }

    @Override
    public void deleteAuthor(int id) {
        authorRepo.deleteById(id);
    }



}