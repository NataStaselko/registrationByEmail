package com.staselko.registrationByEmail.service;

import com.staselko.registrationByEmail.model.User;

public interface VerTokenService {
    String createVerToken(User user);
}
