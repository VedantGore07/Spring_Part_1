package com.vedant.LibraryManagement_Mapping.beans;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="library_branch")

public class LibraryBranch {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int branchId;
    private String branchName;
    private String branchLocation;

    @ManyToMany(mappedBy = "branches")
    private List<Book> books;

    public LibraryBranch(String branchName, String branchLocation) {
        this.branchName = branchName;
        this.branchLocation = branchLocation;
        this.books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public int getBranchId() {
        return branchId;
    }

    public void setBranchId(int branchId) {
        this.branchId = branchId;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public String getBranchLocation() {
        return branchLocation;
    }

    public void setBranchLocation(String branchLocation) {
        this.branchLocation = branchLocation;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public LibraryBranch(){}

    @Override
    public String toString() {
        return "LibraryBranch{" +
                "branchId=" + branchId +
                ", branchName='" + branchName + '\'' +
                ", branchLocation='" + branchLocation + '\'' +
                '}';
    }
}

