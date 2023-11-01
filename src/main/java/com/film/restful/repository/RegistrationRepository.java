package com.film.restful.repository;

import com.film.restful.model.Registration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RegistrationRepository extends JpaRepository<Registration, Long> {
    @Query(value = "SELECT * FROM registration r WHERE r.email = ?1", nativeQuery = true)
    Registration getEmail(String email);

    Optional<Registration> findByEmail(String email);
}
