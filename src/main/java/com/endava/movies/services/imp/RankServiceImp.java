package com.endava.movies.services.imp;

import com.endava.movies.models.Rank;
import com.endava.movies.repositories.MovieRepository;
import com.endava.movies.repositories.RankRepository;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class RankServiceImp {

    private final RankRepository rankRepository;
    private final MovieRepository movieRepository;
    private final MovieServiceImp movieServiceImp;


    public Rank getByUser(Rank rank) {
        val userId = rank.getUserId();
        val movieId = rank.getMovieId();
        Optional<Rank> element = rankRepository.findFirstByUserIdAndMovieId(userId, movieId);
        return element.orElseGet(Rank::new);
    }

    public Rank createByUser(Rank rank) {
        if (!movieRepository.existsById(rank.getMovieId())) {
            movieServiceImp.show(rank.getMovieId());
        }

        val userId = rank.getUserId();
        val movieId = rank.getMovieId();
        Optional<Rank> element = rankRepository.findFirstByUserIdAndMovieId(userId, movieId);
        if (element.isPresent())
            return new Rank();

        return rankRepository.save(rank);
    }

    public Rank updateByUser(Rank rank) {

        val userId = rank.getUserId();
        val movieId = rank.getMovieId();
        Optional<Rank> element = rankRepository.findFirstByUserIdAndMovieId(userId, movieId);

        if (!element.isPresent())
            return new Rank();

        Rank currentRank = element.get();
        rankRepository.deleteById(currentRank.getId());
        currentRank.setQualification(rank.getQualification());
        return rankRepository.save(currentRank);
    }

    public boolean deleteByUser(Rank rank) {
        val userId = rank.getUserId();
        val movieId = rank.getMovieId();
        Optional<Rank> element = rankRepository.findFirstByUserIdAndMovieId(userId, movieId);

        if (!element.isPresent())
            return false;

        Rank currentRank = element.get();
        rankRepository.deleteById(currentRank.getId());
        return !rankRepository.existsById(currentRank.getId());
    }

}
