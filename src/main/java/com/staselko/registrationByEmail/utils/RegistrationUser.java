package com.staselko.registrationByEmail.utils;

import com.staselko.registrationByEmail.dto.UserDto;
import com.staselko.registrationByEmail.dto.VerificationTokenDto;

public interface RegistrationUser {
    void registrationUser(UserDto userDto);
    boolean confirmEmail(VerificationTokenDto tokenDto, Long userId);
}
