package com.staselko.registrationByEmail.controller;

import com.staselko.registrationByEmail.security.JwtRequest;
import com.staselko.registrationByEmail.security.JwtResponse;
import com.staselko.registrationByEmail.security.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;


@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class JwtController {

    private final UserDetailsService userDetailsService;
    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;

    @PostMapping("login")
    public ResponseEntity<JwtResponse> createToken(@RequestBody @Valid JwtRequest request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        final UserDetails userDetails = userDetailsService.loadUserByUsername(request.getUsername());
        final String token = jwtUtil.generateToken(userDetails);
        final String username = jwtUtil.getUsernameFromToken(token);
        return ResponseEntity.ok(new JwtResponse(token, username));
    }

}
