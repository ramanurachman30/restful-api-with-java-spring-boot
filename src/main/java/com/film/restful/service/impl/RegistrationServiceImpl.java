package com.film.restful.service.impl;

import com.film.restful.model.Registration;
import com.film.restful.repository.RegistrationRepository;
import com.film.restful.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class RegistrationServiceImpl implements RegistrationService {
    @Autowired
    private RegistrationRepository registrationRepository;

    @Override
    public Registration getDataByEmail(String email) {
        return registrationRepository.getEmail(email);
    }

    @Override
    public Registration save(Registration row) {
        return registrationRepository.save(row);
    }

    @Override
    public boolean getDataByEmails(String email) {
        Optional<Registration> regist = registrationRepository.findByEmail(email);
        return regist.isPresent();
    }


}
