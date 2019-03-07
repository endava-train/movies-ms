package com.endava.movies.controllers;

import com.endava.movies.models.Catalog;
import com.endava.movies.services.imp.CatalogServiceImp;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@RequestMapping(path="/movies", produces="application/json")
public class CatalogController {

    private final CatalogServiceImp catalogServiceImp;

    @GetMapping
    public ResponseEntity<List<Catalog>> getCatalogsByUser(@RequestBody Catalog catalog) {
//        if (catalog.getUserId() != null && catalog.getMovie() != null)
//            return new ResponseEntity<>(
//                    catalogServiceImp.getCatalogbyUser(catalog.getUserId(), catalog.get()),
//                    HttpStatus.OK
//            );
//
//        return new ResponseEntity<>(new Catalog(), HttpStatus.)
        return null;
    }
}
