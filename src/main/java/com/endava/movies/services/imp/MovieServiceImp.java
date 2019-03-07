package com.endava.movies.services.imp;

import com.endava.movies.models.Movie;
import com.endava.movies.repositories.MovieRepository;
import com.endava.movies.services.MovieService;
import lombok.RequiredArgsConstructor;
import lombok.val;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class MovieServiceImp implements MovieService {

    private final MovieRepository movieRepository;

    public Movie show(int id) {

        var theMovie = new Movie();

        if (!movieRepository.existsById(id)) {
            RestTemplate restTemplate = new RestTemplate();
            val URL_API = "https://api.themoviedb.org/3/movie/" + id +"?api_key=400a36ce2fc2a971530a5a8e873014ac";
            try {
                theMovie = restTemplate.getForObject(URL_API , Movie.class);
            }  catch (Exception e) {
                return theMovie;
            }

            movieRepository.save(theMovie);
        } else {
            Optional<Movie> movie = movieRepository.findById(id);
            if (movie.isPresent()) {
                theMovie = movie.get();
            }
        }

        return theMovie;
    }
}
