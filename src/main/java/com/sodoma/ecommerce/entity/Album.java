package com.sodoma.ecommerce.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class Album extends Product{
	
	@NotBlank
	private String title;
	
	@ElementCollection
	@CollectionTable(name = "album_labels", joinColumns = @JoinColumn(name = "album_id"))
	@Column(name = "label")
	private List<String> label;
	private int releaseYear;
	
	@OneToMany(mappedBy = "album", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonManagedReference
	private List<AlbumVariation> variations;
	
}
