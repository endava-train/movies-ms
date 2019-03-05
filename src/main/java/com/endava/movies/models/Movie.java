package com.endava.movies.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.endava.movies.models.Catalog;
import com.endava.movies.models.Rank;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import java.util.List;


@Data
@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class Movie {

    @Id
    private int id;

    @NotNull
    private String title;

    @NotNull
    @Column(columnDefinition = "TEXT")
    private String overview;

    @NotNull
    private double popularity;

    @OneToMany
    private List<Catalog> catalogs;

    @OneToMany
    private List<Rank> ranks;
}
