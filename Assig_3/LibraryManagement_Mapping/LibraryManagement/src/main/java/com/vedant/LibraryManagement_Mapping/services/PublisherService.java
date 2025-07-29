package com.vedant.LibraryManagement_Mapping.services;

import com.vedant.LibraryManagement_Mapping.beans.Publisher;
import com.vedant.LibraryManagement_Mapping.repos.PublisherRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PublisherService implements PublisherServiceInterface{

    @Autowired
    PublisherRepo publisherRepo;

    @Override
    public void addPublisher(Publisher publisher) {
        publisherRepo.save(publisher);
    }

    @Override
    public List<Publisher> findAll() {
        return publisherRepo.findAll();
    }

    @Override
    public Optional<Publisher> findById(int id) {
        return publisherRepo.findById(id);
    }

    @Override
    public void deletePublisher(int publisherId) {
        publisherRepo.deleteById(publisherId);
    }
}