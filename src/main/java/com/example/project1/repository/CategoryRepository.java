package com.example.project1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.project1.entities.Category;

public interface CategoryRepository extends JpaRepository<Category,Integer> {
    
}
