package com.sodoma.ecommerce.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sodoma.ecommerce.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

	@Query(value = "SELECT p.* FROM products p"
			+ "INNER JOIN products_variation pv ON p.id = pv.product_id"
			+ "WHERE p.active = TRUE"
			+ "GROUP BY p.id"
			+ "HAVING SUM(pv.stock) > 0 ",
			countQuery = "SELECT COUNT(DISTINCT p.id) FROM products p INNER JOIN products_variation pv ON p.id = pv.product_id WHERE p.active = TRUE GROUP BY p.id HAVING SUM(pv.stock) > 0",
			nativeQuery = true)
	Page<Product> findAvailableProductsforDisplay(Pageable pageable);
}
