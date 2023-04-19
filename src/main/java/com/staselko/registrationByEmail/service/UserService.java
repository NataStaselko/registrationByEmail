package com.staselko.registrationByEmail.service;

import com.staselko.registrationByEmail.dto.UserDto;
import com.staselko.registrationByEmail.model.User;

import javax.security.auth.login.LoginException;

public interface UserService {
    User createUser(UserDto userDto);

    void registrationUser(String email);
}
