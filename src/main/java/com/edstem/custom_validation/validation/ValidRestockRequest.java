package com.edstem.custom_validation.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = RestockRequestValidator.class)
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidRestockRequest {
	String message() default "Requested quantity + current stock exceeds warehouse capacity";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}
