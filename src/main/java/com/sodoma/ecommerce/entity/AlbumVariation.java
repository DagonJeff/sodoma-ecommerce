package com.sodoma.ecommerce.entity;

import com.sodoma.ecommerce.util.SkuGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class AlbumVariation extends ProductVariation<Album>{
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private Format format;
	
	
	@Override
	protected String buildDisplayName() {
		
		return format.getDisplayName()+" "+getProduct().getName();
	}
	
	@Override
	protected String buildSku() {
		
		return SkuGenerator.generate("ALB", getId(), format.code, getProduct().getName(), getProduct().getTitle());
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
}
