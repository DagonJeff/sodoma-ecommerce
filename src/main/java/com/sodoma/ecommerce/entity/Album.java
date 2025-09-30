package com.sodoma.ecommerce.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.validation.constraints.NotBlank;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
public class Album extends Product{
	
	@NotBlank
	@Setter
	private String title;
	
	
	@ElementCollection
	@CollectionTable(name = "album_labels", joinColumns = @JoinColumn(name = "album_id"))
	@Column(name = "label")
	private List<String> label = new ArrayList<>();
	
	@Setter
	private int releaseYear;
	
	
	public void addVariation(AlbumVariation variation) {
	//	Para add uma vários variations, o dto recebe um parametro arraylist
	//	a iterção do array list e invocar esse método tartar isso no service
		getVariations().add(variation);
		variation.setProduct(this);
	}
	public void removeVariation(AlbumVariation variation) {
		getVariations().remove(variation);
		variation.setProduct(null);
	}
	
	public void addLabel(String label) {
		this.label.add(label);
	}
	public void removeLabel(String label) {
		this.label.remove(label);
	}
	
}
