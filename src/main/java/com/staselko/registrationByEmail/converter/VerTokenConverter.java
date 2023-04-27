package com.staselko.registrationByEmail.converter;

import com.staselko.registrationByEmail.dto.VerificationTokenDto;
import com.staselko.registrationByEmail.model.VerificationToken;

public interface VerTokenConverter {
    VerificationToken toVerificationToken(VerificationTokenDto verificationTokenDto);
}
