package com.example.project1.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.project1.entities.Film;

public interface FilmRepository extends JpaRepository<Film, Integer> {

    // (1) adding search by year to the repository
     public List<Film> findFilmsByYear(int year);

}
