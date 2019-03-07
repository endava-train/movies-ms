package com.endava.movies.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import com.endava.movies.models.Movie;

@Data
@Entity
public class Rank {

    @Id
    @GeneratedValue
    private Integer id;

    @NotNull
    private int qualification;

    @NotNull
    private String userId;

    @ManyToOne
    private Movie movie;
}
