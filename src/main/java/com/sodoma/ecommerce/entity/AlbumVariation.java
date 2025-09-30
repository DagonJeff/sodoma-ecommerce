package com.sodoma.ecommerce.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.sodoma.ecommerce.util.SkuGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
public class AlbumVariation extends ProductVariation<Album>{
	
	@ManyToOne
	@JoinColumn(name = "product_id")
	@JsonBackReference
	private Album product;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private Format format;
	
	
	@Override
	protected String buildDisplayName() {
		
		return format.getDisplayName()+" "+getProduct().getName();
	}
	
	@Override
	protected String buildSku() {
		
		return SkuGenerator.generate("ALB", format.getCode(), getProduct().getName(), getProduct().getTitle());
	}	
	
	
	@Override
	public Album getProduct() {
		return this.product;
	}

	@Override
	public void setProduct(Album product) {
		this.product = product;
	}
	
	
//=================Enum======================================//
	
	public enum Format{
		CD("CD", "CD"),
		VINYL("Vinil", "VIN"),
		CASSETE("Cassete", "CAS"),
		BOX("Box", "BOX");
		
		@Getter
		private final String displayName;
		
		@Getter
		private final String code;

		Format(String displayname, String code) {
			this.displayName = displayname;
			this.code = code;
		}	
	}


	
//	public static void main(String[] args) {
//		AlbumVariation a = new AlbumVariation();
//		
//		Product p = new Album();
//		
//		p.getVariations().getFirst();	
//	}
}
