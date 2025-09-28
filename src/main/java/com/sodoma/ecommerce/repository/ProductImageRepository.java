package com.sodoma.ecommerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sodoma.ecommerce.entity.ProductImage;
import com.sodoma.ecommerce.entity.ProductVariation;

public interface ProductImageRepository extends JpaRepository<ProductImage, Long>{
	
	List<ProductImage> findByProductVariation(ProductVariation<?> variation);

}
