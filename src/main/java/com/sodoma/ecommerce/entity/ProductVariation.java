package com.sodoma.ecommerce.entity;

import java.math.BigDecimal;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import lombok.Data;

@Data
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class ProductVariation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	
	@Min(0)
	private int stock;
	
	@DecimalMin("0.0")
	@Column(precision = 10, scale = 2, nullable = false)
	private BigDecimal price;
	private String sku;
	
	@OneToMany(mappedBy = "productVariation")
	private List<ProductImage> images;
	

}
