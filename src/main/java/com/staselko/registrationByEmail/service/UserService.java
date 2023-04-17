package com.staselko.registrationByEmail.service;

import com.staselko.registrationByEmail.dto.UserDto;
import com.staselko.registrationByEmail.model.User;

public interface UserService {
    User createUser(UserDto userDto);
}
