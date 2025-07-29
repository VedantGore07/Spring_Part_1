package com.vedant.LibraryManagement_Mapping.beans;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="book")

public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bookId;
    private String bookTitle;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "publisher_id")
    private Publisher publisher;

    @NotEmpty
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "tb_book_author",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id")
    )
    private List<Author> authors;

    @NotEmpty
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "tb_book_branches",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "branch_id")
    )
    private List<LibraryBranch> branches;

    public Book(String title, Publisher Publisher, Author author, LibraryBranch branch) {
        this.bookTitle = title;
        this.publisher = Publisher;
        this.authors = new ArrayList<>();
        this.branches = new ArrayList<>();
        this.authors.add(author);
        this.branches.add(branch);
    }

    public Book(String title) {
        this.bookTitle = title;
    }

    public void addAuthor(Author author) {
        authors.add(author);
    }
    public void addBranch(LibraryBranch branch) {
        branches.add(branch);
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public @NotNull Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(@NotNull Publisher publisher) {
        this.publisher = publisher;
    }

    public @NotEmpty List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(@NotEmpty List<Author> authors) {
        this.authors = authors;
    }

    public @NotEmpty List<LibraryBranch> getBranches() {
        return branches;
    }

    public void setBranches(@NotEmpty List<LibraryBranch> branches) {
        this.branches = branches;
    }

    public Book(){}

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", bookTitle='" + bookTitle + '\'' +
                '}';
    }
}
