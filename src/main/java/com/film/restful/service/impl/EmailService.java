package com.film.restful.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
    @Autowired
    private JavaMailSender javaMailSender;

    public void setVerificationEmail(String to, String otp){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject("Verifikasi Email");
        message.setText("Kode verifikasi Anda adalah: " + otp);

        javaMailSender.send(message);
    }

    public void emailConfirmResetPassword(String to, String newPassword){
        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setTo(to);
        mail.setSubject("Confirmation Reset Password");
        mail.setText("Selamat Password Anda telah direset cok nih password baru lo " + newPassword);

        javaMailSender.send(mail);
    }
}
