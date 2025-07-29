package com.vedant.beans;

public class LibraryService {
    private Book book;

    // Setter Injection
    public void setBook(Book book) {
        this.book = book;
    }

    public void showBooks() {
        System.out.println("Library contains :");
        System.out.println(book);
    }
}
