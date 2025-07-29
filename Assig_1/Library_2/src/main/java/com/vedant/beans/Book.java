package com.vedant.beans;

public class Book {
    private String title;
    private String author;

    public Book() {
        // default constructor
    }

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    // setters
    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    // toString
    @Override
    public String toString() {
        return "Book [Title = " + title + ", Author = " + author + "]";
    }
}
