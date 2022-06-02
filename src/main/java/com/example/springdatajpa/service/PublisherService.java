package com.example.springdatajpa.service;

import com.example.springdatajpa.model.Publisher;
import com.example.springdatajpa.repository.PublisherRepository;
import org.springframework.stereotype.Service;

@Service
public class PublisherService {
    private final PublisherRepository publisherRepository;

    public PublisherService(PublisherRepository publisherRepository) {
        this.publisherRepository = publisherRepository;
    }

    public void addPublisher(Publisher publisher) {
        publisherRepository.save(publisher);
    }
}
