package com.edstem.custom_validation.service;

import com.edstem.custom_validation.model.Product;
import com.edstem.custom_validation.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
	private final ProductRepository productRepository;

	public ProductService(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	public Product save(Product product) {
		return productRepository.save(product);
	}

	public List<Product> findAll() {
		return productRepository.findAll();
	}
}
