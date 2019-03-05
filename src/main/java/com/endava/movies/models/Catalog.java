package com.endava.movies.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import com.endava.movies.models.Movie;

@Data
@Entity
public class Catalog {

    @Id
    @GeneratedValue
    private Integer id;

    @NotNull
    private String type;

    @NotNull
    private String userId;

    @ManyToOne
    private Movie movie;
}
