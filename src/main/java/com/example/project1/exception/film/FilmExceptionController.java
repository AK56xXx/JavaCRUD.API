package com.example.project1.exception.film;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

// don't miss the @ControllerAdvice annotation
@ControllerAdvice
public class FilmExceptionController {

    @ExceptionHandler(FilmNotFoundException.class)
    public ResponseEntity<Object> handleFilmNotFoundException(FilmNotFoundException exception) {
        return new ResponseEntity<>("Film not found!", HttpStatus.NOT_FOUND);
    }

}
