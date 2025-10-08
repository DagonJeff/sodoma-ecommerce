package com.sodoma.ecommerce.enums;

import lombok.Getter;

@Getter
public enum ProductType {
	
	ALBUM("album"),
	CLOTHING("clothing"),
	ACESSORY("acessory");
	
	private final String routeIdentifier;

	ProductType(String routeIdentify) {
		this.routeIdentifier = routeIdentify;
	}
	
}
