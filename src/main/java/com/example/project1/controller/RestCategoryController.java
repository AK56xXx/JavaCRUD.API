package com.example.project1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.project1.entities.Category;
import com.example.project1.service.IServiceCategory;

@RestController
@RequestMapping("/api/categories")
public class RestCategoryController {

    @Autowired
    IServiceCategory iServiceCategory;

    @GetMapping("")
    public List<Category> getAllCategories() {
        return iServiceCategory.findAllCategories();
    }

    @GetMapping("/{id}")
    public Category getCategoryByID(@PathVariable int id) {
        return iServiceCategory.findCategoryById(id);
    }

    @PostMapping("/add")
    public Category addCategory(@RequestBody Category category) {
        return iServiceCategory.createCategory(category);
    }

    @PutMapping("/update")
    public Category updateCategory(@RequestBody Category category) {
        return iServiceCategory.updateCategory(category);
    }

    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable int id) {
        iServiceCategory.deleteCategory(iServiceCategory.findCategoryById(id));
    }

}
