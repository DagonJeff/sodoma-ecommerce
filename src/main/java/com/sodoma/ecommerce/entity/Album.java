package com.sodoma.ecommerce.entity;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
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
	
	
	//=======peruntar sobre==============//
	@ElementCollection
	@CollectionTable(name = "album_labels", joinColumns = @JoinColumn(name = "album_id"))
	@Column(name = "label")
	private List<String> label = new ArrayList<>();
	
	@Setter
	private int releaseYear;
	
	@OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	@JsonManagedReference
	private List<AlbumVariation> variations = new ArrayList<>();
	
	
	public void addVariation(AlbumVariation variation) {
	//	Para add uma vários variations, o dto recebe um parametro arraylist
	//	a iterção do array list e invocar esse método tartar isso no service
		variations.add(variation);
		variation.setProduct(this);
	}
	public void removeVariation(AlbumVariation variation) {
		variations.remove(variation);
		variation.setProduct(null);
	}
	
	public void addLabel(String label) {
		this.label.add(label);
	}
	public void removeLabel(String label) {
		this.label.remove(label);
	}
	
}
