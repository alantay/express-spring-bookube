package com.bookube.springboot_book_service.service;

import com.bookube.springboot_book_service.entity.Author;
import com.bookube.springboot_book_service.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {
    @Autowired
    AuthorRepository authorRepository;

    @Override
    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    @Override
    public Author getAuthorById(Long id) {

        return authorRepository.findById(id).orElse(null);
    }

    @Override
    public Author createAuthor(Author author) {
        return authorRepository.save(author);
    }

    @Override
    public Author updateAuthor(Long id, Author authorDetails) {
        Author author = authorRepository.findById(id).orElse(null);
        if (author != null) {
            author.setEmail(authorDetails.getEmail());
            author.setName(authorDetails.getName());
            return authorRepository.save(author);
        }
        return null;
    }

    @Override
    public void deleteAuthor(Long id) {
        authorRepository.deleteById(id);
    }
}
