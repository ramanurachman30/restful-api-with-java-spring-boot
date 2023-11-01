package com.film.restful.service.impl;

import com.film.restful.model.Registration;
import com.film.restful.repository.RegistrationRepository;
import com.film.restful.repository.UserRepository;
import com.film.restful.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class JwtUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository userDao;

    @Autowired
    private RegistrationRepository registrationRepository;

    @Autowired
    private PasswordEncoder bcryptEncoder;

    @Autowired
    private RegistrationService registrationService;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
//        Registration user = userDao.findByEmail(email);
        Registration user = registrationRepository.getEmail(email);
        if (user == null) {
            throw new UsernameNotFoundException("User not found with username: " + email);
        }
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(),
                new ArrayList<>());
    }

//    public DAOUser save(UserDTO user) {
//        DAOUser newUser = new DAOUser();
//        newUser.setUsername(user.getUsername());
//        newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
//        return userDao.save(newUser);
//    }

//    public Registration saveRegist(RegistDTO regist){
//        Registration newRegist = new Registration();
//
//    }
}
