package com.sodoma.ecommerce.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.sodoma.ecommerce.dto.product.ProductDisplayResponse;
import com.sodoma.ecommerce.entity.Product;
import com.sodoma.ecommerce.entity.ProductVariation;
import com.sodoma.ecommerce.repository.ProductRepository;
import com.sodoma.ecommerce.repository.ProductVariationRepository;
import com.sodoma.ecommerce.service.ProductService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService{
	
	private final ProductRepository productRepository;
	private final ProductVariationRepository productVariationRepository;

	
	@Override
	public Page<ProductDisplayResponse> getProductsForDisplay(Pageable pageable) {
		
		Page<ProductVariation<?>> variationPage = productVariationRepository.findDisplayVariations(pageable);
		
		List<ProductDisplayResponse> displayList = variationPage.getContent().stream()
				.map(this::mapVariationToDisplayResponse)
				.collect(Collectors.toList());
		return new PageImpl<>(displayList, pageable, variationPage.getTotalElements());
	}
	
	
	private ProductDisplayResponse mapVariationToDisplayResponse(ProductVariation<?> variation) {
		
		Product product = variation.getProduct();
		
		String mainImage = variation.getImages().stream()
				.findFirst()
				.map(img -> img.getPath())
				.orElse(null);
		return new ProductDisplayResponse(
				variation.getId(),
				product.getName(),
				product.getType().getRouteIdentifier(),
				variation.getDisplayName(),
				variation.getPrice(),
				mainImage,
				null,
				null);
	}

	@Override
	public Product saveProduct(Product product) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
