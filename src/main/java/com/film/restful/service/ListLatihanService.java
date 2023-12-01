package com.film.restful.service;

import java.util.List;

import com.film.restful.model.ListLatihan;

public interface ListLatihanService {
    ListLatihan save(ListLatihan row);

    List<ListLatihan> getAllListLatihan();

    ListLatihan getById(long id);

    void deleteOneItemListLatihan(long id);
}
