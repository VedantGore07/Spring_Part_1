package com.vedant.libraryManagement.repos;

import com.vedant.libraryManagement.beans.Books;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepo extends JpaRepository<Books, Integer> {

    List<Books> findByAuthor(String author);
    List<Books> findByGenre(String genre);
    List<Books> findByPublicationYearGreaterThan(int year);

}
