package com.sodoma.ecommerce.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.sodoma.ecommerce.dto.product.ProductDisplayResponse;
import com.sodoma.ecommerce.entity.Product;

public interface ProductService {
	
	Page<ProductDisplayResponse> getProductsForDisplay(Pageable pageable);
	
	Product saveProduct(Product product);
	Product findById(Long id);

}
