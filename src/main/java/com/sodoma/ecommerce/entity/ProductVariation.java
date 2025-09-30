package com.sodoma.ecommerce.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

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
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class ProductVariation <T extends Product>{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	private Long id;
	
	@Setter
	@Min(0)
	private int stock;
	
	@Setter
	@DecimalMin("0.0")
	@Column(precision = 10, scale = 2, nullable = false)
	private BigDecimal price;
	
	@Column(nullable = false, unique = true)
	private String sku;
	
	@PrePersist
	public void ensureSku() {
		if(this.sku == null)
			this.sku = buildSku();
	}
	
	
	@OneToMany(mappedBy = "productVariation", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonManagedReference
	private List<ProductImage> images = new ArrayList<>();
	
	public void addImages(ProductImage image) {
		images.add(image);
		image.setProductVariation(this);
	}
	
	public void removeImage(ProductImage image) {
		images.remove(image);
		image.setProductVariation(null);
	}
	
	
	public String getDisplayName() {
		return buildDisplayName();
	}
	
	public String getSku() {
		return this.sku;
	}
	
	public abstract T getProduct();
	public abstract void setProduct(T product);
	
	protected abstract String buildDisplayName();
	protected abstract String buildSku();
}
