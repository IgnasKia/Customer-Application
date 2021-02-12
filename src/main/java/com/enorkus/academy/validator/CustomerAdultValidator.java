package com.enorkus.academy.validator;

import com.enorkus.academy.exception.ValidationException;

public class CustomerAdultValidator extends Validator<Integer> {

    @Override
    public void validate(Integer age, String message) {
        if (age < 18) {
            throw new ValidationException(message);
        }
    }
}