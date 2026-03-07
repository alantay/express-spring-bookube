package com.bookube.springboot_book_service.service;

import com.bookube.springboot_book_service.entity.Book;
import com.bookube.springboot_book_service.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService{

    @Autowired BookRepository bookRepository;

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book getBookById(Long id) {
        return bookRepository.findById(id).orElse(null);
    }

    @Override
    public Book createBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Book updateBook(Long id, Book bookDetails) {
        Book book = bookRepository.findById(id).orElse(null);
        if(book !=null){
            book.setDescription(bookDetails.getDescription());
            book.setAuthor(bookDetails.getAuthor());
            book.setTitle(bookDetails.getTitle());
            return bookRepository.save(book);
        }
        return null;
    }

    @Override
    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }
}
