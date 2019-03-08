package com.endava.movies.controllers;

import com.endava.movies.models.Catalog;
import com.endava.movies.services.imp.CatalogServiceImp;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Response;
import java.util.List;

@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@RequestMapping(path="/catalogs", produces="application/json")
public class CatalogController {

    private final CatalogServiceImp catalogServiceImp;

    @GetMapping
    public ResponseEntity<List<Catalog>> getByUser(@RequestBody Catalog catalog) {
        return new ResponseEntity<>(catalogServiceImp.getByUser(catalog), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Catalog> createByUser(@RequestBody Catalog catalog) {
        Catalog element = catalogServiceImp.createByUser(catalog);
        if (element.equals(new Catalog())) {
            return new ResponseEntity<>(element, HttpStatus.UNPROCESSABLE_ENTITY);
        }

        return new ResponseEntity<>(element, HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<String> deleteByUser(@RequestBody Catalog catalog) {
        if (catalogServiceImp.deleteByUser(catalog))
            return new ResponseEntity<>("", HttpStatus.NO_CONTENT);

        return new ResponseEntity<>("", HttpStatus.NOT_FOUND);
    }
}
