package com.ailson.taskflow.validation.nonwhitespace;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class NonWhitespaceValidator implements ConstraintValidator<NonWhitespace, String> {
    @Override
    public void initialize(NonWhitespace constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        if (value == null) return true;

        // Returns false if it contains blanks
        return !value.trim().isEmpty();
    }
}
