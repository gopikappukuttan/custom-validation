package com.edstem.custom_validation.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = PriceValidator.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidPrice {
	String message() default "Price must be positive and have up to two decimal places";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}
