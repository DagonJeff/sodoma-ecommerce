package com.sodoma.ecommerce.entity;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Data
public class AlbumVariation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private Format format;
	
	@Min(0)
	private int stock;
	
	@NotNull
	@DecimalMin("0.0")
	@Column(precision = 10, scale = 2, nullable = false)
	private BigDecimal price;
	
	@ManyToOne
	@JoinColumn(name = "album_id")
	@JsonBackReference
	private Album album;
	
	public enum Format{
		CD, VINYL, CASSETE, BOX;
	}

}
