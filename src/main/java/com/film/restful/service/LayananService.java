package com.film.restful.service;

import java.util.List;

import com.film.restful.model.Layanan;

public interface LayananService {
    Layanan save(Layanan row);

    List<Layanan> getAll();

    Layanan getDatabyId(long id);

    void deleteLayananByid(long id);
}
