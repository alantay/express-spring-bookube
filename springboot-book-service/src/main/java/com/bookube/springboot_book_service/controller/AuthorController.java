package com.bookube.springboot_book_service.controller;

import com.bookube.springboot_book_service.entity.Author;
import com.bookube.springboot_book_service.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/authors")
public class AuthorController {

    @Autowired
    AuthorService authorService;

    @GetMapping
    public List<Author> getAllAuthors() {
        return authorService.getAllAuthors();
    }

    @GetMapping("/{id}")
    public Author getAuthorById(@PathVariable Long id) {
        return authorService.getAuthorById(id);
    }

    @PostMapping
    public Author createAuthor(@RequestBody Author author) {
        return authorService.createAuthor(author);
    }

    @PutMapping
    public Author updateAuthor(@PathVariable Long id, @RequestBody Author authorDetails) {
        return authorService.updateAuthor(id, authorDetails);
    }

    @DeleteMapping
    public void deleteAuthor(@PathVariable Long id) {
        authorService.deleteAuthor(id);
    }
}
