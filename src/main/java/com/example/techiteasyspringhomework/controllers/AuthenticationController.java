package com.example.techiteasyspringhomework.controllers;

import com.example.techiteasyspringhomework.models.CustomUserDetailsService;
import com.example.techiteasyspringhomework.payload.AuthenticationRequest;
import com.example.techiteasyspringhomework.payload.AuthenticationResponse;
import com.example.techiteasyspringhomework.utils.JwtUtil;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.security.Principal;

@CrossOrigin
public class AuthenticationController {

    private final AuthenticationManager authenticationManager;

    private final CustomUserDetailsService customUserDetailsService;
    private final JwtUtil jwtUtil;


    public AuthenticationController(AuthenticationManager authenticationManager, CustomUserDetailsService customUserDetailsService, JwtUtil jwtUtil) {
        this.authenticationManager = authenticationManager;
        this.customUserDetailsService = customUserDetailsService;
        this.jwtUtil = jwtUtil;
    }

    // geeft principal (basis gebruiker gegevens) terug van de ingelogde gebruiker
    @GetMapping(value = "/authenticated")
    public ResponseEntity<Object> authenticated(Authentication authentication, Principal principal) {
        return ResponseEntity.ok().body(principal);
    }

    // geeft jwt token terug wanneer gebruiker juiste inloggegeens opgeeft

    @PostMapping(value = "/authenticate")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {

        String username = authenticationRequest.getUsername();
        String password = authenticationRequest.getPassword();

        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(username, password)
            );
        }
        catch (BadCredentialsException ex) {
            throw new Exception("Incorrect username or password", ex);
        }

        final UserDetails userDetails = customUserDetailsService
                .loadUserByUsername(username);

        final String jwt = jwtUtil.generateToken(userDetails);

        return ResponseEntity.ok(new AuthenticationResponse(jwt));
    }



}
