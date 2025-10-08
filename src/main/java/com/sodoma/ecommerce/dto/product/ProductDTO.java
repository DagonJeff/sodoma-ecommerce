package com.sodoma.ecommerce.dto.product;

import java.math.BigDecimal;

public record ProductDTO (
		Long id,
		String name,
		String description,
		BigDecimal price,
		String category,
		boolean active
	 ) {}
