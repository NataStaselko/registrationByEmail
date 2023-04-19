package com.staselko.registrationByEmail.dto;

import com.staselko.registrationByEmail.validator.EmailValid;
import com.staselko.registrationByEmail.validator.LoginUniqueValid;
import com.staselko.registrationByEmail.validator.PasswordValid;
import com.staselko.registrationByEmail.validator.TextValid;
import lombok.Data;

@Data
public class UserDto {

    private Long id;

    @EmailValid
    private String email;

    @LoginUniqueValid
    @TextValid
    private String login;

    @PasswordValid
    private String password;
}
