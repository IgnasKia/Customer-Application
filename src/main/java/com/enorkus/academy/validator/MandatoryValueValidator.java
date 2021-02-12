package com.enorkus.academy.validator;

import com.enorkus.academy.exception.ValidationException;
import org.apache.commons.lang3.StringUtils;

public class MandatoryValueValidator extends Validator<String> {
    @Override
    public void validate(String attribute, String message) {
        if(StringUtils.isBlank(attribute)) {
            throw new ValidationException(message);
        }
    }
}