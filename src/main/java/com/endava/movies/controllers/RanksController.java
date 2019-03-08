package com.endava.movies.controllers;

import com.endava.movies.models.Rank;
import com.endava.movies.services.imp.RankServiceImp;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@RequestMapping(path="/ranks", produces="application/json")
public class RanksController {

    private final RankServiceImp rankServiceImp;

    @GetMapping
    public ResponseEntity<Rank> getByUser(@RequestBody Rank rank) {
        Rank currentRank = rankServiceImp.getByUser(rank);
        if (currentRank.equals(new Rank()))
            return new ResponseEntity<>(currentRank, HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(currentRank, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Rank> createByUser(@RequestBody Rank rank) {
        Rank currentRank = rankServiceImp.createByUser(rank);
        if (currentRank.equals(new Rank()))
            return new ResponseEntity<>(currentRank, HttpStatus.BAD_REQUEST);

        return new ResponseEntity<>(currentRank, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Rank> updateByUser(@RequestBody Rank rank) {
        Rank currentRank = rankServiceImp.updateByUser(rank);
        if (currentRank.equals(new Rank()))
            return new ResponseEntity<>(currentRank, HttpStatus.BAD_REQUEST);
        
        return new ResponseEntity<>(currentRank, HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<String> deleteByUser(@RequestBody Rank rank) {
        if (rankServiceImp.deleteByUser(rank))
            return new ResponseEntity<>("", HttpStatus.NO_CONTENT);

        return new ResponseEntity<>("", HttpStatus.NOT_FOUND);
    }
}
