package com.example.project1.service;

import java.util.List;

import com.example.project1.entities.Category;

public interface IServiceCategory {

    public Category createCategory(Category category);
    public Category findCategoryById(int id);
    public Category updateCategory(Category category);
    public List<Category> findAllCategories();
    public void deleteCategory(Category category);
    
}
