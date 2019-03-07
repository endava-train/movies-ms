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
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@RequestMapping(path="/movies", produces="application/json")
public class MoviesController {

    private final MovieServiceImp movieServiceImp;

    @GetMapping("/{id}")
    public ResponseEntity<Movie> show(@PathVariable("id") Integer id) {
        Movie theMovie = movieServiceImp.show(id);
        if (theMovie.equals(new Movie()))
            return new ResponseEntity<>(new Movie(), HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(movieServiceImp.show(id), HttpStatus.OK);
    }

}
