package com.edstem.custom_validation.model;

import com.edstem.custom_validation.validation.ValidCategory;
import com.edstem.custom_validation.validation.ValidPrice;
import com.edstem.custom_validation.validation.ValidSku;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "products")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank(message = "Name must not be blank")
	private String name;

	@ValidSku
	private String sku;

	@ValidCategory
	private String category;
	@ValidPrice
	private BigDecimal price;

	@Min(value = 0, message = "Stock quantity must be non-negative")
	private Integer StockQuantity;
}
