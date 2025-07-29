package com.vedant.LibraryManagement_Mapping.repos;

import com.vedant.LibraryManagement_Mapping.beans.LibraryBranch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LibraryBranchRepo extends JpaRepository<LibraryBranch, Integer> {

}
