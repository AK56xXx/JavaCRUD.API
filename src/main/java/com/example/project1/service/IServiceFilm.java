package com.example.project1.service;

import java.util.List;

import com.example.project1.entities.Film;

public interface IServiceFilm {

    public Film createFilm(Film film);

    public boolean filmExist(int id);

    public Film findFilmById(int id);

    public Film updateFilm(Film film);

    public List<Film> findAllFilms();

    public void deleteFilm(Film film);

    // (2) adding search by year to the service interface
    public List<Film> findFilmsByYear(int year);

}
