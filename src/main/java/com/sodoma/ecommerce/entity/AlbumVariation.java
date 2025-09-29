package com.sodoma.ecommerce.entity;

import com.sodoma.ecommerce.util.SkuGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
//	}
}
