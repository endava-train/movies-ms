package com.endava.movies.services.imp;

import com.endava.movies.models.Catalog;
import com.endava.movies.models.Rank;
import com.endava.movies.repositories.CatalogRepository;
import com.endava.movies.repositories.MovieRepository;
import com.endava.movies.repositories.RankRepository;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CatalogServiceImp {

    private final CatalogRepository catalogRepository;
    private final MovieRepository movieRepository;
    private final RankRepository rankRepository;
    private final MovieServiceImp movieServiceImp;


    public List<Catalog> getByUser(Catalog catalog) {
        val userId = catalog.getUserId();
        val movieId = catalog.getMovieId();
        return catalogRepository.findByUserIdAndMovieId(userId, movieId);
    }

    public Catalog createByUser(Catalog catalog) {
        val userId = catalog.getUserId();
        val movieId = catalog.getMovieId();

        if (!movieRepository.existsById(movieId)) {
            movieServiceImp.show(movieId);
        }

        List<Catalog> elements = catalogRepository.findByUserIdAndMovieId(userId, movieId);

        if (elements.stream().anyMatch(x -> x.getUserId() == userId && x.getMovieId() == movieId && x.getType().equals(catalog.getType())))
            return new Catalog();

        switch (catalog.getType()) {
            case "watched":
                Optional<Rank> elementRank = rankRepository.findFirstByUserIdAndMovieId(userId, movieId);
                if (!elementRank.isPresent())
                    return new Catalog();

                elements.stream().forEach(x -> {
                    if (x.getType().equals("planToWatch"))
                        catalogRepository.deleteById(x.getId());
                });
                break;

            case "favorites":


                if (!elements.stream().anyMatch(x -> x.getType().equals("watched"))) {
                    return new Catalog();
                }

                break;
            case "planToWatch":
                if (!elements.isEmpty())
                    return new Catalog();
                break;

            default:
                return new Catalog();
        }

        catalogRepository.save(catalog);
        return catalog;
    }

    public boolean deleteByUser(Catalog catalog) {
        val userId = catalog.getUserId();
        val movieId = catalog.getMovieId();
        val qualification = catalog.getType();
        Optional<Catalog> element = catalogRepository.findFirstByUserIdAndMovieIdAndType(userId, movieId, qualification);
        if (!element.isPresent())
            return false;

        catalogRepository.deleteById(element.get().getId());
        return true;
    }


}
