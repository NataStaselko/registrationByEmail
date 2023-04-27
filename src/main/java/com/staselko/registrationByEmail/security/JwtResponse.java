package com.staselko.registrationByEmail.security;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class JwtResponse implements Serializable {
    private String token;
    private String login;
}