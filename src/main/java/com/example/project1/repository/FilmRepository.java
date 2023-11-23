package com.example.project1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.project1.entities.Film;

public interface FilmRepository extends JpaRepository<Film,Integer> {
    
}
