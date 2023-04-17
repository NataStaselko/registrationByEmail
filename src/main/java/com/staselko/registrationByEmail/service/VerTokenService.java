package com.staselko.registrationByEmail.service;

import com.staselko.registrationByEmail.dto.UserDto;

public interface VerTokenService {
    String createVerToken(UserDto userDto);
}
