package com.endava.movies.repositories;

import com.endava.movies.models.Catalog;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CatalogRepository extends CrudRepository<Catalog, Integer> {
    List<Catalog> findByUserIdAndMovieId(int userId, int movieId);
}