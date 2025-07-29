package com.vedant.LibraryManagement_Mapping.repos;

import com.vedant.LibraryManagement_Mapping.beans.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepo extends JpaRepository<Book, Integer> {
}
