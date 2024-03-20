package com.demo.springboot.validators;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Arrays;
import java.util.List;

public class ValidCountries implements ConstraintValidator<ValidCountry,String> {

    List<String > countriesList = Arrays.asList("INDIA","AUSTRIA","JAPAN","CANADA","DUBAI");
    @Override
    public void initialize(ValidCountry constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return countriesList.contains(s);
    }
}
