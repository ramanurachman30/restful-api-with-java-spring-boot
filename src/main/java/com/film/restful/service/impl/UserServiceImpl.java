package com.film.restful.service.impl;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Service
public class UserServiceImpl {
    private Map<String, String> otpStorage = new HashMap<>();
    private Set<String> verifiedEmails = new HashSet<>();

    public void saveOTP(String email, String otp) {
        otpStorage.put(email, otp);
    }

    public boolean verifyOTP(String email, String otp) {
        String storedOtp = otpStorage.get(email);
        return storedOtp != null && storedOtp.equals(otp);
    }

    public void markEmailAsVerified(String email) {
        verifiedEmails.add(email);
    }

    public boolean isEmailVerified(String email) {
        return verifiedEmails.contains(email);
    }
}
