package com.staselko.registrationByEmail.security;

import com.staselko.registrationByEmail.model.User;
import com.staselko.registrationByEmail.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepo.findByEmail(email)
                .filter(User::isEnabled)
                .map(UserDetailsImpl::new)
                .orElseThrow(() -> new RuntimeException("User not found with name " + email));
    }
}