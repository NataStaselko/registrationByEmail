package com.staselko.registrationByEmail.validator;

import com.staselko.registrationByEmail.repo.UserRepo;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class LoginUniqueValidator implements ConstraintValidator<LoginUniqueValid, String> {

    private final UserRepo userRepo;

    public LoginUniqueValidator(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public boolean isValid(String login, ConstraintValidatorContext constraintValidatorContext) {
        return userRepo.findByLogin(login).isEmpty();
    }
}
