package com.endava.movies.services;

import com.endava.movies.models.Rank;

public interface RankService {
    Rank getByUser(Rank rank);
    Rank createByUser(Rank rank);
    Rank updateByUser(Rank rank);
    boolean deleteByUser(Rank rank);
}
