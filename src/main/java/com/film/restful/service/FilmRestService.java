package com.film.restful.service;

import java.util.List;
import java.util.Optional;

import com.film.restful.model.FilmRest;

public interface FilmRestService {
    FilmRest save(FilmRest row);

    List<FilmRest> getAll();

    FilmRest getDataById(long id);

    Optional<FilmRest> findDataById(long id);

    void deleteDataById(long id);
}
