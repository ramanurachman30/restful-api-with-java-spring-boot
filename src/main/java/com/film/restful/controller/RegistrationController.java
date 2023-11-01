package com.film.restful.controller;

import com.film.restful.constant.StudiCaseConstant;
import com.film.restful.contract.request.RequestRegister;
import com.film.restful.contract.response.ResponseRegist;
import com.film.restful.model.Registration;
import com.film.restful.service.RegistrationService;
import com.film.restful.service.impl.EmailService;
import com.film.restful.service.impl.UserServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Random;

@RestController
@CrossOrigin
public class RegistrationController {
    private static Logger log = LogManager.getLogger(RegistrationController.class);

    @Autowired
    private RegistrationService registrationService;

    @Autowired
    private EmailService emailService;

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private PasswordEncoder bcryptEncoder;

    @GetMapping(StudiCaseConstant.GET_REGIST)
    public ResponseEntity<ResponseRegist> findDataRegist(@PathVariable("email") String email){
        ResponseRegist response = new ResponseRegist();
        Registration metadata;
        metadata = registrationService.getDataByEmail(email);
        if (metadata != null) {
            response.setCode("00");
            response.setDescription("Your email has been regist");
            response.setMetadata(metadata);
        }else{
            response.setCode("500");
            response.setDescription("Sorry, Your email is not registered yet !");
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping(StudiCaseConstant.CREATE_REGIST)
    public  ResponseEntity<ResponseRegist> regist(@RequestBody RequestRegister metadatas){
        ResponseRegist response = new ResponseRegist();

        String otp = generateOTP();

        Registration registration = new Registration();
        if (registrationService.getDataByEmails(metadatas.getEmail())){
            response.setCode("500");
            response.setDescription("Anda Sudah terdaftar !!");
            response.setMetadata(null);

            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        registration.setNama(metadatas.getNama());
        registration.setEmail(metadatas.getEmail());
        emailService.setVerificationEmail(metadatas.getEmail(), otp);
        registration.setPassword(bcryptEncoder.encode(metadatas.getPassword()));
        registration.setNoHp(metadatas.getNoHp());
        registration.setNoKartu(metadatas.getNoKartu());
        registration.setCvv(metadatas.getCvv());
        registration.setNamaPemegangKartu(metadatas.getNamaPemegangKartu());
        registrationService.save(registration);


        response.setCode("00");
        response.setDescription("Anda berhasi regist Dan Cek kode otp anda di email");
        response.setMetadata(registration);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    public static String generateOTP() {
        Random random = new Random();
        int otp = 100000 + random.nextInt(900000); // Generate random 6-digit OTP
        return String.valueOf(otp);
    }

    @PostMapping(StudiCaseConstant.EMAIL_VERIFICATION)
    public String verifyEmail(@RequestParam String email, @RequestParam String otp) {
        if (userService.verifyOTP(email, otp)) {
            userService.markEmailAsVerified(email);
            return "Email berhasil diverifikasi.";
        } else {
            return "Kode verifikasi tidak valid.";
        }
    }
}
