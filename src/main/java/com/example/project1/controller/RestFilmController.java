package com.example.project1.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.project1.entities.Film;
import com.example.project1.exception.film.FilmNotFoundException;
import com.example.project1.service.IServiceFilm;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/films")
public class RestFilmController {

    @Autowired
    IServiceFilm iServiceFilm;

    @GetMapping("")
    public List<Film> findAllFilms() {
        return iServiceFilm.findAllFilms();
    }

    public boolean isNotInt(Object variable) {
        return !(variable instanceof Integer);
    }

    @GetMapping("/{id}")
    public Film findFilmById(@PathVariable int id) {
        // exception
        if (!iServiceFilm.filmExist(id)) {
            throw new FilmNotFoundException();
        }
        return iServiceFilm.findFilmById(id);
    }

    @PostMapping("/add")
    public Film AddFilm(@RequestBody Film film) {
        return iServiceFilm.createFilm(film);
    }

    @PutMapping("/update")
    public Film UpdateFilm(@RequestBody Film film) {
        return iServiceFilm.updateFilm(film);
    }

    @DeleteMapping("/{id}")
    public void DeleteFilm(@PathVariable int id) {
        iServiceFilm.deleteFilm(iServiceFilm.findFilmById(id));
    }

}
