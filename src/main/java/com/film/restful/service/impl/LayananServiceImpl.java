package com.film.restful.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.film.restful.model.Layanan;
import com.film.restful.repository.LayananRepository;
import com.film.restful.service.LayananService;

@Service
public class LayananServiceImpl implements LayananService{
    @Autowired
    private LayananRepository layananRepository;

    @Override
    public Layanan save(Layanan row) {
        return layananRepository.save(row);
    }

    @Override
    public List<Layanan> getAll() {
        return layananRepository.findAll();
    }

    @Override
    public Layanan getDatabyId(long id) {
        return layananRepository.getByIdLayanan(id);
    }

    @Override
    public void deleteLayananByid(long id) {
        layananRepository.deleteById(id);
    }
}
