package com.film.restful.service.impl;

import com.film.restful.model.Registration;
import com.film.restful.repository.RegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Service
public class UserServiceImpl {

    @Autowired
    private RegistrationRepository registrationRepository;

    private Map<String, String> otpStorage = new HashMap<>();
    private Set<String> verifiedEmails = new HashSet<>();

    public void saveOTP(String email, String otp) {
        otpStorage.put(email, otp);
    }

    public boolean verifyOTP(String email, String otp) {
        String storedOtp = otpStorage.get(email);
        return storedOtp != null && storedOtp.equals(otp);
    }

    public void resetPassword(String email, String newPassword){
        Registration regist = registrationRepository.getEmail(email);
        if (regist != null){
            regist.setPassword(newPassword);
            registrationRepository.save(regist);
        }else {
            throw new RuntimeException("Pengguna tidak ditemukan");
        }
    }

    public void markEmailAsVerified(String email) {
        verifiedEmails.add(email);
    }

    public boolean isEmailVerified(String email) {
        return verifiedEmails.contains(email);
    }
}
