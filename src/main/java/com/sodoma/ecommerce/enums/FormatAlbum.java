package com.sodoma.ecommerce.enums;

import lombok.Getter;

@Getter
public enum FormatAlbum {
	
	CD("CD", "CD"),
	VINYL("Vinil", "VIN"),
	CASSETE("Cassete", "CAS"),
	BOX("Box", "BOX");

	private final String name;
	private final String code;
	
	FormatAlbum(String name, String code) {
		this.name = name;
		this.code = code;
	}
}
