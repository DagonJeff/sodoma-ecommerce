package com.sodoma.ecommerce.dto;

import java.util.List;

import org.springframework.http.HttpHeaders;

public record HeaderResponse<T>(
		
		List<T> items,
		HttpHeaders headers
		) {}
