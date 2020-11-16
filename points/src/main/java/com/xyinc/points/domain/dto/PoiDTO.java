package com.xyinc.points.domain.dto;

import org.modelmapper.ModelMapper;

import com.xyinc.points.domain.Poi;

import lombok.Data;

@Data
public class PoiDTO {
	
	private Long id;
	private String name;
	private int coordX;
	private int coordY;

	public static PoiDTO create(Poi p) {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(p, PoiDTO.class);
	}
}
