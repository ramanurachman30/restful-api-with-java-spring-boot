package com.film.restful.repository;

import com.film.restful.model.DAOUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<DAOUser, Integer> {
    DAOUser findByUsername(String username);

//    Registration findByEmail(String email);
}
