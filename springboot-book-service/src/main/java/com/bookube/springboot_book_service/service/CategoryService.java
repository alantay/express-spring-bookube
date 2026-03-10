package com.bookube.springboot_book_service.service;

import com.bookube.springboot_book_service.entity.Category;

import java.util.List;

public interface CategoryService {
    List<Category> getAllCategories();

    Category getCategoryById(Long id);

    Category createCategory(Category category);

    Category updateCategory(Long id, Category categoryDetails);

    void deleteCategory(Long id);
}
