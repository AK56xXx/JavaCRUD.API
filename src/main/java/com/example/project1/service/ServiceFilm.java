package com.example.project1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.project1.entities.Film;
import com.example.project1.repository.FilmRepository;
import org.springframework.stereotype.Service;


@Service
public class ServiceFilm implements IServiceFilm {

    @Autowired
    FilmRepository filmRepository;

    @Override
    public Film createFilm(Film film) {
        return filmRepository.save(film);
    }

    @Override
    public Film findFilmById(int id) {
        return filmRepository.findById(id).get();
    }

    @Override
    public Film updateFilm(Film film) {
        return filmRepository.save(film);
    }

    @Override
    public List<Film> findAllFilms() {
        return filmRepository.findAll();
    }

    @Override
    public void deleteFilm(Film film) {
        filmRepository.delete(film);
    }
    
}
