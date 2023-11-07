package com.film.restful.controller;

import com.film.restful.config.security.config.JwtTokenUtil;
import com.film.restful.constant.StudiCaseConstant;
import com.film.restful.contract.request.LoginRequest;
import com.film.restful.contract.request.RequestResetPassword;
import com.film.restful.contract.response.ResponseLogin;
import com.film.restful.contract.response.ResponseResetPassword;
import com.film.restful.model.Registration;
import com.film.restful.service.impl.EmailService;
import com.film.restful.service.impl.JwtUserDetailsService;
import com.film.restful.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@RestController
@CrossOrigin
public class LoginController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private EmailService emailService;

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private JwtUserDetailsService userDetailsService;

    @RequestMapping(value = StudiCaseConstant.LOGIN, method = RequestMethod.POST)
    public ResponseEntity<ResponseLogin> createAuthenticationToken(@RequestBody LoginRequest authenticationRequest) throws Exception {

        ResponseLogin response = new ResponseLogin();

        authenticate(authenticationRequest.getEmail(), authenticationRequest.getPassword());

        final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getEmail());

//        final String token = jwtTokenUtil.generateToken(userDetails);
        HttpHeaders token = new HttpHeaders();
        token.get(jwtTokenUtil.generateToken(userDetails));
        token.set("TOKEN_AUTHORIZATION", jwtTokenUtil.generateToken(userDetails));

        response.setCode("00");
        response.setDescription("Selamat anda sudah login Check token anda di headers");
        return ResponseEntity.ok().headers(token).body(response);
    }

    @PostMapping(StudiCaseConstant.LOGOUT)
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "Anda berhasil keluar.";
    }

//    @RequestMapping(value = "/register", method = RequestMethod.POST)
//    public ResponseEntity<?> saveUser(@RequestBody UserDTO user) throws Exception {
//        return ResponseEntity.ok(userDetailsService.save(user));
//    }

    private void authenticate(String email, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }

    @PostMapping(StudiCaseConstant.RESET_PASSWORD)
    public ResponseEntity<ResponseResetPassword> resetPassword(@RequestParam String email, @RequestParam String newPassword){
        ResponseResetPassword response = new ResponseResetPassword();
        emailService.emailConfirmResetPassword(email, newPassword);
        userService.resetPassword(email, newPassword);
        response.setCode("00");
        response.setMessage("Selamat Password Anda telah di reset cek email untuk mendapatakan password baru");

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
