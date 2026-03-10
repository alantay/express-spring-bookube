package com.bookube.springboot_book_service.service;

import com.bookube.springboot_book_service.dto.BookCreateRequest;
import com.bookube.springboot_book_service.entity.Author;
import com.bookube.springboot_book_service.entity.Book;
import com.bookube.springboot_book_service.entity.Category;
import com.bookube.springboot_book_service.repository.AuthorRepository;
import com.bookube.springboot_book_service.repository.BookRepository;
import com.bookube.springboot_book_service.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    BookRepository bookRepository;

    @Autowired
    AuthorRepository authorRepository;


    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book getBookById(Long id) {
        return bookRepository.findById(id).orElse(null);
    }

    @Override
    public Book createBook(BookCreateRequest request) {
        Book book = new Book();
        book.setTitle(request.getTitle());
        book.setDescription(request.getDescription());

        Author author = authorRepository.findByName(request.getAuthorName());
        if (author == null) {
            // Create new author
            author = new Author();
            author.setName(request.getAuthorName());
            author.setEmail(request.getAuthorEmail());
            author = authorRepository.save(author);
        }
        book.setAuthor(author);


        if (request.getCategoryNames() != null && !request.getCategoryNames().isEmpty()) {
            Set<Category> categories = new HashSet<>();
            for (String categoryName : request.getCategoryNames()) {
                Category category = categoryRepository.findByName(categoryName);
                if (category == null) {
                    // Create new category
                    category = new Category();
                    category.setName(categoryName);
                    category = categoryRepository.save(category);
                }
                categories.add(category);
            }
            book.setCategories(categories);
        }
        return bookRepository.save(book);
    }

    @Override
    public List<Book> createBooksInBulk(List<BookCreateRequest> requests) {
        List<Book> books = new ArrayList<>();

        for (BookCreateRequest request : requests) {
            Book book = createBook(request);
            books.add(book);
        }

        return books;
    }

    @Override
    public Book updateBook(Long id, Book bookDetails) {
        Book book = bookRepository.findById(id).orElse(null);
        if (book != null) {
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
