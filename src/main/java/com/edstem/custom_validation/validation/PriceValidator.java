package com.edstem.custom_validation.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.math.BigDecimal;

public class PriceValidator implements ConstraintValidator<ValidPrice, BigDecimal> {
	@Override
	public boolean isValid(BigDecimal price, ConstraintValidatorContext constraintValidatorContext) {
		if (price == null) return true;
		if (price.compareTo(BigDecimal.ZERO) <= 0) return false;
		return price.scale() <= 2;
	}
}
