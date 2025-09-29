package com.sodoma.ecommerce.dto;

import java.math.BigDecimal;

public record AlbumVariationDTO(
		Long id,
		int stock,
		BigDecimal price,
		String format
		) {}
