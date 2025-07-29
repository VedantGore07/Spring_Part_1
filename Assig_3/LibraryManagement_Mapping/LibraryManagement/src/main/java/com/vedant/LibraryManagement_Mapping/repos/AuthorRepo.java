package com.vedant.LibraryManagement_Mapping.repos;

import com.vedant.LibraryManagement_Mapping.beans.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepo extends JpaRepository<Author, Integer> {
}
