package com.example.springdatajpa.service;

import com.example.springdatajpa.model.Book;
import com.example.springdatajpa.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> addBook(Book book) {
       // book.getBookPublishers().forEach(bookPublisher -> bookPublisher.setBook(book));
        bookRepository.save(book);
        return bookList();
    }

    public List<Book> bookList() {
        return bookRepository.findAll();
    }

}
