package com.film.restful.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.film.restful.model.ListLatihan;

@Repository
public interface ListLatihanRepository extends JpaRepository<ListLatihan, Long>{
    @Query(value = "SELECT * FROM ListLatihan ll where ll.id=?1", nativeQuery = true)
    ListLatihan getById(long id);
}
