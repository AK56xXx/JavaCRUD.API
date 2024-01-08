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

    @DeleteMapping("/delete/{id}")
    public void DeleteFilm(@PathVariable int id) {
        iServiceFilm.deleteFilm(iServiceFilm.findFilmById(id));
    }

    // (4) finally adding search by year to the REST API controllers
    // check (FilmRepository, IServiceFilm, ServiceFilm) for the full implementation
    // this is a custom API/method added in FilRepository -> IServiceFilm ->
    // ServiceFilm -> RestFilmController
    @GetMapping("/year/{year}")
    public List<Film> findFilmsByYear(@PathVariable int year) {
        return iServiceFilm.findFilmsByYear(year);
    }

}
