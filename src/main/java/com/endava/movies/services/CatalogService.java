package com.endava.movies.services;

import com.endava.movies.models.Catalog;

import java.util.List;

public interface CatalogService {
    List<Catalog> getByUser(Catalog catalog);
    Catalog createByUser(Catalog catalog);
    boolean deleteByUser(Catalog catalog);
}
