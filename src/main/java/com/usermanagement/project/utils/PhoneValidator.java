package com.usermanagement.project.utils;

import java.util.Objects;
import java.util.regex.Pattern;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PhoneValidator implements ConstraintValidator<Phone, String> {

    private static final String E164_REGEX = "^\\+?[1-9]\\d{1,14}$";
    private static final Pattern E164_PATTERN = Pattern.compile(E164_REGEX);

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (Objects.isNull(value) || value.trim().isEmpty()) {
            return true;
        }
        return E164_PATTERN.matcher(value.trim()).matches();
    }
}