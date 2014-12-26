package com.gruby.sr.validators;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 *
 * @author ja
 */

@Documented
@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = GoodNameValidator.class)
public @interface GoodName {
    
    String message() default "{com.gruby.sr.validators.NOT_GOOD_NAME}";
    
    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
