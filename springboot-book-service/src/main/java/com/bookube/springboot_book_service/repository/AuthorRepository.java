package com.bookube.springboot_book_service.repository;

import com.bookube.springboot_book_service.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
    Author findByName(String name);

    List<Author> findByNameIn(Set<String> names);
}
