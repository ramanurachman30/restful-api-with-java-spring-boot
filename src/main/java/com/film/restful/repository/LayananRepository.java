package com.film.restful.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.film.restful.model.Layanan;

@Repository
public interface LayananRepository extends JpaRepository<Layanan, Long>{
    @Query(value = "SELECT * FROM Layanan l WHERE l.id=?1", nativeQuery = true)
    Layanan getByIdLayanan(Long id);
}
