package com.staselko.registrationByEmail.repo;

import com.staselko.registrationByEmail.model.User;
import com.staselko.registrationByEmail.model.VerificationToken;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VerTokenRepo extends JpaRepository<VerificationToken, Long> {
    Optional<VerificationToken> findByToken(String token);
}
