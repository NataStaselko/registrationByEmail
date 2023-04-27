package com.staselko.registrationByEmail.service.impl;

import com.staselko.registrationByEmail.converter.UserConverter;
import com.staselko.registrationByEmail.dto.UserDto;
import com.staselko.registrationByEmail.exception.ResourceNotFoundException;
import com.staselko.registrationByEmail.model.User;
import com.staselko.registrationByEmail.repo.UserRepo;
import com.staselko.registrationByEmail.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepo userRepo;
    private final UserConverter userConverter;

    @Override
    public User createUser(UserDto userDto){
        return userRepo.save(userConverter.toUser(userDto));
    }

    @Override
    public User getUserById(long userId) {
        return userRepo.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
    }

    @Override
    public void updateUser(User user) {
        userRepo.save(user);
    }
}
