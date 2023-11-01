package com.film.restful.service;

import com.film.restful.model.Registration;

public interface RegistrationService {
    Registration getDataByEmail(String email);

    Registration save(Registration row);

    boolean getDataByEmails(String email);


}
