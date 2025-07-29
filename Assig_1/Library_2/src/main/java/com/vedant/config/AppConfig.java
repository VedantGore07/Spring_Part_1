package com.vedant.config;

import com.vedant.beans.Book;
import com.vedant.beans.LibraryService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class AppConfig {

    @Bean
    public Book book() {
        Book book = new Book();
        book.setTitle("Death Note");
        book.setAuthor("Tsugumi Ohba");
        return book;
    }

    @Bean
    public LibraryService libraryService() {
        LibraryService service = new LibraryService();
        service.setBook(book());  // setter injection
        return service;
    }
}