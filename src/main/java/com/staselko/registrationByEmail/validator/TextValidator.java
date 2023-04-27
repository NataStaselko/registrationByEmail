package com.staselko.registrationByEmail.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class TextValidator implements ConstraintValidator<TextValid, String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        if (value == null || value.matches("[a-zA-Z\\d~.\"(),:;<>@\\[\\]!#$%&'*+-/=?^_`{|}]*")){
            return true;
        }
        return false;
    }
}
