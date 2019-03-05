package com.endava.movies.controllers;

import com.endava.movies.models.Movie;
import com.endava.movies.services.imp.MovieServiceImp;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/movies", produces="application/json")
public class MoviesController {

    private MovieServiceImp movieServiceImp;

    @Autowired
    public MoviesController(MovieServiceImp movieServiceImp) {
        this.movieServiceImp = movieServiceImp;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Movie> show(@PathVariable("id") Integer id) {
        return new ResponseEntity<>(movieServiceImp.show(id), HttpStatus.OK);
    }

}
