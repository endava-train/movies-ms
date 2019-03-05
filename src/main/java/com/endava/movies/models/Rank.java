package com.endava.movies.models;


import lombok.Data;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

@Data
@Entity
public class Rank {

    @NotNull
    private int qualification;
}
