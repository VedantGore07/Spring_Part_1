package com.vedant.LibraryManagement_Mapping.services;

import com.vedant.LibraryManagement_Mapping.beans.LibraryBranch;
import com.vedant.LibraryManagement_Mapping.repos.LibraryBranchRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LibraryBranchService implements LibraryBranchServiceInterface {
    @Autowired
    LibraryBranchRepo libraryBranchRepo;

    @Override
    public void addLibraryBranch(LibraryBranch libraryBranch) {
        libraryBranchRepo.save(libraryBranch);
    }

    @Override
    public List<LibraryBranch> findAll() {
        return libraryBranchRepo.findAll();
    }

    @Override
    public Optional<LibraryBranch> findById(int id) {
        return libraryBranchRepo.findById(id);
    }

    @Override
    public void deleteLibraryBranch(int id) {
        libraryBranchRepo.deleteById(id);
    }
}
