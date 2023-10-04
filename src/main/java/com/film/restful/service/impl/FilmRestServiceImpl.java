package com.film.restful.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.film.restful.model.FilmRest;
import com.film.restful.repository.FilmRestRepository;
import com.film.restful.service.FilmRestService;

@Service
public class FilmRestServiceImpl implements FilmRestService {
    
    @Autowired
    private FilmRestRepository filmRestRepository;

    @Override
    public FilmRest save(FilmRest row) {
        return filmRestRepository.save(row);
    }

    @Override
    public List<FilmRest> getAll() {
        return filmRestRepository.findAll();
    }

    @Override
    public FilmRest getDataById(long id) {
        return filmRestRepository.getById(id);
    }

    @Override
    public Optional<FilmRest> findDataById(long id) {
        return filmRestRepository.findById(id);
    }

    @Override
    public void deleteDataById(long id) {
        filmRestRepository.deleteById(id);
    }
}
