package com.staselko.registrationByEmail.service.impl;

import com.staselko.registrationByEmail.dto.UserDto;
import com.staselko.registrationByEmail.model.User;
import com.staselko.registrationByEmail.model.VerificationToken;
import com.staselko.registrationByEmail.repo.VerTokenRepo;
import com.staselko.registrationByEmail.service.UserService;
import com.staselko.registrationByEmail.service.VerTokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VerTokenServiceImpl implements VerTokenService {

    private final VerTokenRepo verTokenRepo;

    @Override
    public String createVerToken(User user) {
        VerificationToken verificationToken = new VerificationToken();
        verificationToken.setUser(user);
        verTokenRepo.save(verificationToken);
        return verificationToken.getToken();
    }
}
