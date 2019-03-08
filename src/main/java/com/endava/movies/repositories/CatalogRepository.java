package com.endava.movies.repositories;

import com.endava.movies.models.Catalog;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface CatalogRepository extends CrudRepository<Catalog, Integer> {
    List<Catalog> findByUserIdAndMovieId(int userId, int movieId);
    Optional<Catalog> findFirstByUserIdAndMovieIdAndType(int userId, int movieId, String qualification);
}