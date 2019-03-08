package com.endava.movies.controllers;

import com.endava.movies.models.Catalog;
import com.endava.movies.services.imp.CatalogServiceImp;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@RequestMapping(path="/catalogs", produces="application/json")
public class CatalogController {

    private final CatalogServiceImp catalogServiceImp;

    @GetMapping
    public ResponseEntity<List<Catalog>> getByUser(@RequestBody Catalog catalog) {
        val userId = catalog.getUserId();
        val movieId = catalog.getMovieId();
        return new ResponseEntity<>(catalogServiceImp.getCatalogsByUser(userId, movieId), HttpStatus.OK);
    }

    @PostMapping
    public String doMagic(@RequestBody Catalog catalog) {

        return catalog.toString();
    }
}
