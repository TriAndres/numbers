package ru.practikum.numbers.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class NonNullValidator implements ConstraintValidator<NonNull, Long> {

    @Override
    public boolean isValid(Long value, ConstraintValidatorContext context) {
        return value != null;
    }
}