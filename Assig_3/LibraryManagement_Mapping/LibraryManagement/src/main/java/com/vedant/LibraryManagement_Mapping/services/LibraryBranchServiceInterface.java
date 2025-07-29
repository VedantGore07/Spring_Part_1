package com.vedant.LibraryManagement_Mapping.services;

import com.vedant.LibraryManagement_Mapping.beans.LibraryBranch;

import java.util.List;
import java.util.Optional;

public interface LibraryBranchServiceInterface {

    void addLibraryBranch(LibraryBranch libraryBranch);
    List<LibraryBranch> findAll();
    Optional<LibraryBranch> findById(int id);
    void deleteLibraryBranch(int id);
}
