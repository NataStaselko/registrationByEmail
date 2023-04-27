package com.staselko.registrationByEmail.service;

import com.staselko.registrationByEmail.dto.VerificationTokenDto;
import com.staselko.registrationByEmail.model.User;
import com.staselko.registrationByEmail.model.VerificationToken;


public interface VerTokenService {
    String createVerToken(User user);

    VerificationToken getVerTokenByTokenDto(VerificationTokenDto tokenDto);
    boolean checkToken(VerificationToken token);

    VerificationToken updateVerToken(VerificationToken token);
}
