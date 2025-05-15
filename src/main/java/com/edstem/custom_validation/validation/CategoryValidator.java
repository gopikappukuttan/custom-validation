package com.edstem.custom_validation.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Set;

public class CategoryValidator implements ConstraintValidator<ValidCategory, String> {
	private final Set<String> ALLOWED = Set.of("Electronics", "Books", "Clothing", "Appliances");

	@Override
	public boolean isValid(String category, ConstraintValidatorContext context) {
		boolean isValid = category != null && ALLOWED.stream()
				.anyMatch(allowed -> allowed.equalsIgnoreCase(category));

		if (!isValid) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(
							"Invalid category. Allowed values: " + String.join(", ", ALLOWED))
					.addConstraintViolation();
		}

		return isValid;
	}
}
