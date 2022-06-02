package com.example.springdatajpa.controller;

import com.example.springdatajpa.model.Publisher;
import com.example.springdatajpa.service.PublisherService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PublisherController {
    private final PublisherService publisherService;

    public PublisherController(PublisherService publisherService) {
        this.publisherService = publisherService;
    }

    @PostMapping("add-publisher")
    public ResponseEntity<?> addPublisher(@RequestBody Publisher publisher) {
        publisherService.addPublisher(publisher);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }
}
