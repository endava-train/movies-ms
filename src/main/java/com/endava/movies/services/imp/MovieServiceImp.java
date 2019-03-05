package com.endava.movies.services.imp;

import com.endava.movies.models.Movie;
import com.endava.movies.repositories.MovieRepository;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MovieServiceImp {

    @Autowired
    private MovieRepository movieRepository;

    public Movie show(int id) {
        Movie theMovie = null;
        if (!movieRepository.existsById(id)) {
            RestTemplate restTemplate = new RestTemplate();
            val URL_API = "https://api.themoviedb.org/3/movie/" + id +"?api_key=400a36ce2fc2a971530a5a8e873014ac";
            theMovie = restTemplate.getForObject(URL_API , Movie.class);
            movieRepository.save(theMovie);
        } else {
            Optional<Movie> movie = movieRepository.findById(id);
            if (movie.isPresent())
                theMovie = movie.get();
        }

        return theMovie;
    }
}
