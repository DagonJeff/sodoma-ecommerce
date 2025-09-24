package com.sodoma.ecommerce.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class AlbumVariation extends ProductVariation{
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private Format format;
	
	@ManyToOne
	@JoinColumn(name = "album_id")
	@JsonBackReference
	private Album album;
	
	public enum Format{
		CD, VINYL, CASSETE, BOX;
	}

}
