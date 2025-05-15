package com.edstem.custom_validation.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = SkuValidator.class)
@Documented
public @interface ValidSku {
	String message() default "SKU format is invalid. Must follow pattern ABC-12345";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}
