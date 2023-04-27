package com.staselko.registrationByEmail.converter;

import com.staselko.registrationByEmail.dto.VerificationTokenDto;
import com.staselko.registrationByEmail.model.VerificationToken;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class VerTokenConverterImpl implements VerTokenConverter{
    @Override
    public VerificationToken toVerificationToken(VerificationTokenDto verificationTokenDto) {
        VerificationToken verificationToken = new VerificationToken();
        verificationToken.setToken(verificationTokenDto.getToken());
        return null;
    }
}
