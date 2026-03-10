package com.bookube.springboot_book_service.controller;

import com.bookube.springboot_book_service.dto.BookCreateRequest;
import com.bookube.springboot_book_service.entity.Book;
import com.bookube.springboot_book_service.service.BookService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @PostMapping
    public Book createBook(@Valid @RequestBody BookCreateRequest request) {
        return bookService.createBook(request);

    }

    @GetMapping("/{id}")
    public Book getBookById(@PathVariable Long id) {
        return bookService.getBookById(id);
    }

    @PutMapping("/{id}")
    public Book updateBook(@PathVariable Long id, @Valid @RequestBody Book updatedBookDetails) {
        return bookService.updateBook(id, updatedBookDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
    }

    @PostMapping("/bulk")
    public List<Book> createBooksInBulk(@Valid @RequestBody List<BookCreateRequest> requests) {
        return bookService.createBooksInBulk(requests);
    }
}
