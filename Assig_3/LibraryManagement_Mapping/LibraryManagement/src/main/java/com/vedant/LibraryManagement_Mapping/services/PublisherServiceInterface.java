package com.vedant.LibraryManagement_Mapping.services;

import com.vedant.LibraryManagement_Mapping.beans.Publisher;

import java.util.List;
import java.util.Optional;

public interface PublisherServiceInterface {

    void addPublisher(Publisher publisher);
    List<Publisher> findAll();
    Optional<Publisher> findById(int id);
    void deletePublisher(int publisherId);

}
