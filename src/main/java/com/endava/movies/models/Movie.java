package com.endava.movies.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

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
}
