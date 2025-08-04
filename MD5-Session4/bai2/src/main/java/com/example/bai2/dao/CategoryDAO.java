package com.example.bai2.dao;

import com.example.bai2.model.Category;

import java.util.List;

public interface CategoryDAO {
    List<Category> getAllCategories();

    Category getCategoryById(int id);

    boolean addCategory(Category category);

    boolean updateCategory(Category category);

    boolean deleteCategory(int id);
}
