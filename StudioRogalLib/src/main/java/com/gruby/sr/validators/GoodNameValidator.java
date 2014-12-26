package com.gruby.sr.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import lombok.extern.java.Log;

/**
 *
 * @author ja
 */
@Log
public class GoodNameValidator implements ConstraintValidator<GoodName, String> {

    @Override
    public void initialize(GoodName constraintAnnotation) {
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null)
            return false;
        if (value.length() < 2)
            return false;
        if (value.length() > 20)
            return false;
        if (value.startsWith("a") || value.startsWith("A"))
            return false;        
        return true;
    }
}
