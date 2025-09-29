package com.sodoma.ecommerce.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.sodoma.ecommerce.dto.AlbumVariationDTO;
import com.sodoma.ecommerce.entity.AlbumVariation;

@Mapper(componentModel = "Spring")
public interface AbumVariationMapper {
	
	@Mapping(target = "format", expression = "java(var.getFormat().name()")
	AlbumVariationDTO toDTO(AlbumVariation var);
	
	@Mapping(target = "format", expression = "java(com.sodoma.ecommerce.entity.AlbumVariation.Format.valueOf(dto.format()))")
	AlbumVariation fromDTO(AlbumVariationDTO dto);

}
