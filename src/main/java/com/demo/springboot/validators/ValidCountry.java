package com.demo.springboot.validators;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ValidCountries.class)
public @interface ValidCountry {
    String message() default "This is not a valid country";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
    String fromAmountFiled() default "fromAmount";
    String toAmountFiled() default "toAmount";


}
