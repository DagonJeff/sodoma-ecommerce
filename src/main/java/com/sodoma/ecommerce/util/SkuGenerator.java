package com.sodoma.ecommerce.util;

import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SkuGenerator {
	
	public static String generate(String prefix, String... attributes) {
		String randomCode = UUID.randomUUID()
				.toString()
				.substring(0, 6)
				.toUpperCase();
		
		String base = Stream.of(attributes)
				.filter(a -> a != null && !a.isBlank())
				.map(String::toUpperCase)
				.map(a -> a.length() > 3 ? a.substring(0, 3) : a)
				.collect(Collectors.joining("-", prefix + "-", ""));
		
		return base + "-" + randomCode;
	}
}
