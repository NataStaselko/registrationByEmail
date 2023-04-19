package com.staselko.registrationByEmail.controller;

import com.staselko.registrationByEmail.dto.UserDto;
import com.staselko.registrationByEmail.model.User;
import com.staselko.registrationByEmail.service.UserService;
import com.staselko.registrationByEmail.service.VerTokenService;
import com.staselko.registrationByEmail.service.mail.MailService;
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
    private final VerTokenService verTokenService;
    private final UserService userService;
    private final MailService mailService;

    @PostMapping("registration")
    public ResponseEntity<String> createVerificationToken(@RequestBody @Valid UserDto userDto){
        User user = userService.createUser(userDto);
        String token = verTokenService.createVerToken(user);
        mailService.sendMailToUser(user, token);
        return ResponseEntity.ok(token);
    }
}
