package com.sodoma.ecommerce.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sodoma.ecommerce.entity.ProductVariation;

public interface ProductVariationRepository extends JpaRepository<ProductVariation<?>, Long>{
	
	@Query(value = 
			"SELECT * FROM ("
			+ "    SELECT pv.*,"
			+ "              ROW_NUMBER() OVER ("
			+ "                PARTITION BY pv.product_id"
			+ "                ORDER BY pv.stock DESC, pv.price ASC"
			+ ") AS rn"
			+ "    FROM product_variation pv"
			+ "    INNER JOIN products p ON pv.product_id = p.id"
			+ "    WHERE p.active = TRUE AND pv.stock > 0"
			+ ") AS ranked_variations"
			+ "WHERE rn <= 2",
			nativeQuery = true)
	Page<ProductVariation<?>> findDisplayVariations(Pageable pageable);

}
