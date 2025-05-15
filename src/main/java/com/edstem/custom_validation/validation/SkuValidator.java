package com.edstem.custom_validation.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class SkuValidator implements ConstraintValidator<ValidSku, String> {

	private static final String SKU_PATTERN = "[A-Z]{3}-\\d{5}";

	@Override
	public boolean isValid(String sku, ConstraintValidatorContext context) {
		if (sku == null) return false;
		return sku.matches(SKU_PATTERN);
	}
}
