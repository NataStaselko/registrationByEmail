package com.staselko.registrationByEmail.service.impl;

import com.staselko.registrationByEmail.dto.VerificationTokenDto;
import com.staselko.registrationByEmail.exception.ResourceNotFoundException;
import com.staselko.registrationByEmail.model.User;
import com.staselko.registrationByEmail.model.VerificationToken;
import com.staselko.registrationByEmail.repo.VerTokenRepo;
import com.staselko.registrationByEmail.service.VerTokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

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

    @Override
    public VerificationToken getVerTokenByTokenDto(VerificationTokenDto tokenDto) {
        return verTokenRepo.findByToken(tokenDto.getToken())
                .orElseThrow(() -> new ResourceNotFoundException("Verification token not found") );
    }

    @Override
    public boolean checkToken(VerificationToken token) {
            LocalDateTime date = token.getExpiryDate();
            return date.isAfter(LocalDateTime.now().withNano(0));
        }

    @Override
    public VerificationToken updateVerToken(VerificationToken token) {
        VerificationToken token1 = new VerificationToken();
        token.setToken(token1.getToken());
        token.setExpiryDate(token1.getExpiryDate());
        verTokenRepo.save(token);
        return token;
    }
}
