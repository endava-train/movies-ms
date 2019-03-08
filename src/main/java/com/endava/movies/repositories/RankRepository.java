package com.endava.movies.repositories;

import com.endava.movies.models.Rank;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface RankRepository extends CrudRepository<Rank, Integer> {
    Optional<Rank> findFirstByUserIdAndMovieId(int userId, int movieId);
}
