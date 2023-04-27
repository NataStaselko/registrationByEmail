package com.staselko.registrationByEmail.controller;

import com.staselko.registrationByEmail.dto.UserDto;
import com.staselko.registrationByEmail.dto.VerificationTokenDto;
import com.staselko.registrationByEmail.utils.RegistrationUser;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class RegistrationController {
    private final RegistrationUser registrationUser;

    @PostMapping("registration")
    public ResponseEntity<Void> createVerificationToken(@RequestBody @Valid UserDto userDto){
        registrationUser.registrationUser(userDto);
        return ResponseEntity.ok().build();
    }

    @PostMapping("confirm_email")
    public ResponseEntity<Boolean> confirmationOfRegistration(@RequestParam (value = "userId") Long userId,
                                                              @RequestBody VerificationTokenDto tokenDto){
        return ResponseEntity.ok(registrationUser.confirmEmail(tokenDto, userId));
    }
}
