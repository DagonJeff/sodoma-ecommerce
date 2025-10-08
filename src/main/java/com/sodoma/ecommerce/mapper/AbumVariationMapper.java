package com.sodoma.ecommerce.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.sodoma.ecommerce.dto.AlbumVariationDTO;
import com.sodoma.ecommerce.entity.AlbumVariation;
import com.sodoma.ecommerce.enums.FormatAlbum;

@Mapper(componentModel = "Spring")
public interface AbumVariationMapper {
	
	@Mapping(target = "format", expression = "java(var.getFormat().name())") 
	AlbumVariationDTO toDTO(AlbumVariation var);
	
	
	@Mapping(target = "format", expression = "java(FormatAlbum.valueOf(dto.format()))")
	AlbumVariation fromDTO(AlbumVariationDTO dto);

}
