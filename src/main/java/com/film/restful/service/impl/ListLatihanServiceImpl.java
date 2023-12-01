package com.film.restful.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.film.restful.model.ListLatihan;
import com.film.restful.repository.ListLatihanRepository;
import com.film.restful.service.ListLatihanService;

@Service
public class ListLatihanServiceImpl implements ListLatihanService{

    @Autowired
    private ListLatihanRepository listLatihanRepository;

    @Override
    public ListLatihan save(ListLatihan row) {
        return listLatihanRepository.save(row);
    }

    @Override
    public List<ListLatihan> getAllListLatihan() {
        return listLatihanRepository.findAll();
    }

    @Override
    public ListLatihan getById(long id) {
        return listLatihanRepository.getById(id);
    }

    @Override
    public void deleteOneItemListLatihan(long id) {
        listLatihanRepository.deleteById(id);
    }
    
}
