package com.example.petshop.validations.constraintvalidation;

import com.example.petshop.validations.NotZero;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class NotZeroValidation implements ConstraintValidator<NotZero,Integer> {

    @Override
    public void initialize(NotZero constraintAnnotation) {

    }

    @Override
    public boolean isValid(Integer integer, ConstraintValidatorContext constraintValidatorContext) {
        return integer!=0;
    }
}
