package com.film.restful.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.film.restful.model.FilmRest;

@Repository
public interface FilmRestRepository extends JpaRepository<FilmRest, Long> {
    
}
