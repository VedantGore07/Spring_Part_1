package com.vedant.LibraryManagement_Mapping.repos;

import com.vedant.LibraryManagement_Mapping.beans.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PublisherRepo extends JpaRepository<Publisher,Integer> {

}
