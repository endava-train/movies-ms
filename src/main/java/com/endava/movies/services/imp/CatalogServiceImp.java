package com.endava.movies.services.imp;

import com.endava.movies.models.Catalog;
import com.endava.movies.repositories.CatalogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CatalogServiceImp {

    private final CatalogRepository catalogRepository;

    public List<Catalog> getCatalogsByUser(int userId, int movieId) {
        return catalogRepository.findByUserIdAndMovieId(userId, movieId);
    }

    
}
