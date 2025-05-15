package com.edstem.custom_validation.controller;

import com.edstem.custom_validation.contract.RestockRequest;
import com.edstem.custom_validation.model.Product;
import com.edstem.custom_validation.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/products")
public class ProductController {
	private final ProductService productService;

	public ProductController(ProductService productService) {
		this.productService = productService;
	}

	@PostMapping
	public ResponseEntity<?> addProduct(@Valid @RequestBody Product product, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return ResponseEntity.badRequest().body(getErrors(bindingResult));
		}
		return ResponseEntity.ok(productService.save(product));
	}

	@PostMapping("/restock")
	public ResponseEntity<?> restock(@Valid @RequestBody RestockRequest request, BindingResult result) {
		if (result.hasErrors()) {
			Map<String, String> errors = new HashMap<>();
			result.getFieldErrors().forEach(error ->
					errors.put(error.getField(), error.getDefaultMessage())
			);
			result.getGlobalErrors().forEach(error ->
					errors.put("error", error.getDefaultMessage())
			);
			return ResponseEntity.badRequest().body(errors);
		}

		return ResponseEntity.ok("Restock request is valid!");
	}


	private Map<String, String> getErrors(BindingResult bindingResult) {
		Map<String, String> errors = new HashMap<>();

		bindingResult.getFieldErrors().forEach(error ->
				errors.put(error.getField(), error.getDefaultMessage())
		);

		bindingResult.getGlobalErrors().forEach(error ->
				errors.put("error", error.getDefaultMessage())
		);

		return errors;
	}

}
