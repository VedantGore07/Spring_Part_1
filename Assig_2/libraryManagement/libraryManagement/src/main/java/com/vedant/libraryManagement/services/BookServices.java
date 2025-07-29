package com.vedant.libraryManagement.services;

import com.vedant.libraryManagement.beans.Books;
import com.vedant.libraryManagement.repos.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServices implements BookServicesInterface {

    @Autowired
    BookRepo bookRepo;

    @Override
    public void addBooks(Books books) {
        bookRepo.save(books);
    }

    @Override
    public Optional<Books> FindBookById(int Id) {
        return bookRepo.findById(Id);
    }

    @Override
    public void updateBook(Books books) {
        bookRepo.save(books);
    }

    @Override
    public void deleteBook(int BookId) {
        bookRepo.deleteById(BookId);
    }

    @Override
    public List<Books> getBooksByAuthor(String author) {
        return bookRepo.findByAuthor(author);
    }

    @Override
    public List<Books> getBooksByGenre(String genre) {
        return bookRepo.findByGenre(genre);
    }

    @Override
    public List<Books> getBooksAfterYear(int year) {
        return bookRepo.findByPublicationYearGreaterThan(year);
    }

}
