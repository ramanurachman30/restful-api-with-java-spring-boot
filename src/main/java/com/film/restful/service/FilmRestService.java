package com.film.restful.service;

import java.util.List;

import com.film.restful.model.FilmRest;

public interface FilmRestService {
    FilmRest save(FilmRest row);

    List<FilmRest> getAll();
}
