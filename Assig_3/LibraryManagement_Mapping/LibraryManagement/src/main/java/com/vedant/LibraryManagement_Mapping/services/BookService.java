package com.vedant.LibraryManagement_Mapping.services;

import com.vedant.LibraryManagement_Mapping.beans.Author;
import com.vedant.LibraryManagement_Mapping.beans.Book;
import com.vedant.LibraryManagement_Mapping.beans.LibraryBranch;
import com.vedant.LibraryManagement_Mapping.beans.Publisher;
import com.vedant.LibraryManagement_Mapping.repos.AuthorRepo;
import com.vedant.LibraryManagement_Mapping.repos.BookRepo;
import com.vedant.LibraryManagement_Mapping.repos.LibraryBranchRepo;
import com.vedant.LibraryManagement_Mapping.repos.PublisherRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class BookService implements BookServiceInterface{
    @Autowired
    BookRepo bookRepo;

    @Autowired
    AuthorRepo authorRepo;

    @Autowired
    LibraryBranchRepo libraryBranchRepo;

    @Transactional
    public void addBook(Book book) {
        bookRepo.save(book);
    }

    @Transactional
    public void addAuthorToBook(int bookId, int authorId) {
        Book book = bookRepo.findById(bookId).orElseThrow();
        Author author = authorRepo.findById(authorId).orElseThrow();
        book.addAuthor(author);
        bookRepo.save(book);
    }

    @Transactional
    public void addbranchToBook(int bookId, int branchId) {
        Book book = bookRepo.findById(bookId).orElseThrow();
        LibraryBranch branch = libraryBranchRepo.findById(branchId).orElseThrow();
        book.addBranch(branch);
        bookRepo.save(book);
    }


    @Override
    public List<Book> findAll() {
        return bookRepo.findAll();
    }

    @Override
    public Optional<Book> findById(int id) {
        return bookRepo.findById(id);
    }

    @Override
    public void deleteById(int id) {
        bookRepo.deleteById(id);
    }

}
