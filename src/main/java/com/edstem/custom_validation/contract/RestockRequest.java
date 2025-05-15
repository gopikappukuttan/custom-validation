package com.edstem.custom_validation.contract;

import com.edstem.custom_validation.validation.ValidRestockRequest;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@ValidRestockRequest
@Getter
public class RestockRequest {
	@NotNull(message = "Requested quantity must not be null")
	@Min(0)
	private int requestedQuantity;

	@NotNull
	@Min(0)
	private int currentStock;

	@NotNull
	@Min(1)
	private int warehouseCapacity;

}
