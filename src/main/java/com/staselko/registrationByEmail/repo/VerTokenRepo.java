package com.staselko.registrationByEmail.repo;

import com.staselko.registrationByEmail.model.VerificationToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VerTokenRepo extends JpaRepository<VerificationToken, Long> {
}
