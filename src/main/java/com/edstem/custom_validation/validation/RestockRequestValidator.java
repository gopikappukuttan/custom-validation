package com.edstem.custom_validation.validation;

import com.edstem.custom_validation.contract.RestockRequest;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;



public class RestockRequestValidator implements ConstraintValidator<ValidRestockRequest, RestockRequest> {
	@Override
	public boolean isValid(RestockRequest request, ConstraintValidatorContext context) {
		if (request == null) {
			return true;
		}

		if (request.getRequestedQuantity() < 0) {
			return true;
		}

		if (request.getRequestedQuantity() + request.getCurrentStock() > request.getWarehouseCapacity()) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate("Requested quantity + current stock exceeds warehouse capacity")
					.addConstraintViolation();
			return false;
		}

		return true;
	}
}
