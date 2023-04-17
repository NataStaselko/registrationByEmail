package com.staselko.registrationByEmail.controller;

import com.staselko.registrationByEmail.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class RegistrationController {
    @PostMapping("registration")
    public ResponseEntity<Void> createVerificationToken(@RequestBody @Valid UserDto userDto){
        return ResponseEntity.ok().build();
    }
}
