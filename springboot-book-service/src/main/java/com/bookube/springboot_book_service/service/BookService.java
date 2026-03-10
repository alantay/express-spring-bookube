package com.bookube.springboot_book_service.service;

import com.bookube.springboot_book_service.dto.BookCreateRequest;
import com.bookube.springboot_book_service.entity.Book;

import java.util.List;

public interface BookService {
    List<Book> getAllBooks();

    Book getBookById(Long id);

    Book createBook(BookCreateRequest request);

    Book updateBook(Long id, Book bookDetails);

    List<Book> createBooksInBulk(List<BookCreateRequest> requests);

    void deleteBook(Long id);
}
