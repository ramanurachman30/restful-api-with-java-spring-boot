package com.film.restful.service;

import java.util.List;
import java.util.Optional;

import com.film.restful.model.Layanan;

public interface LayananService {
    Layanan save(Layanan row);

    List<Layanan> getAll();

    Layanan getDatabyId(long id);
}
