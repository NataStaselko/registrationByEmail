package com.staselko.registrationByEmail.dto;

import com.staselko.registrationByEmail.validator.EmailValid;
import com.staselko.registrationByEmail.validator.PasswordValid;
import lombok.Data;

@Data
public class UserDto {

    private Long id;

    @EmailValid
    private String email;

    @PasswordValid
    private String password;
}
