package com.sodoma.ecommerce.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PostPersist;
import jakarta.persistence.PostUpdate;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

@Data
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class ProductVariation <T extends Product>{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Setter(AccessLevel.NONE)
	private Long Id;
	
	@ManyToOne
	@JoinColumn(name = "product_id")
	@JsonBackReference
	private T product;
	
	@Min(0)
	private int stock;
	
	@DecimalMin("0.0")
	@Column(precision = 10, scale = 2, nullable = false)
	private BigDecimal price;
	
	@Setter(AccessLevel.NONE)
	@Column(nullable = false, unique = true)
	private String sku;
	
	@PostPersist
	@PostUpdate
	public void ensureSku() {
		this.sku = buildSku();
	}
	
	@OneToMany(mappedBy = "productVariation", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JsonManagedReference
	private List<ProductImage> images = new ArrayList<>();
	
	
	public String getDisplayName() {
		return buildDisplayName();
	}
	
	public String getSku() {
		return this.sku;
	}
	
	protected abstract String buildDisplayName();
	protected abstract String buildSku();
}
