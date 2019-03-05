package com.endava.movies.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

@Data
@Entity
public class List {

    @NotNull
    private String type;

    @NotNull
    private int movieId;

    @NotNull
    private int userId;

}
