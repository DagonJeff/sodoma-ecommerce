package com.sodoma.ecommerce.dto.product;

import java.math.BigDecimal;

public record ProductDisplayResponse(
		
		Long id,
		String nome,
		String productType,
		
		String displayName,
		BigDecimal displayPrice,
		String mainImageUrl,
		
		Double productRating,
		Integer reviewsCount
		) {}
