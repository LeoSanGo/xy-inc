package com.xyinc.points.domain.dto;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

import org.modelmapper.ModelMapper;

import com.xyinc.points.domain.Poi;

import lombok.Data;

@Data
public class PoiDTO {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	private String name;
	
	@Positive
	private int coordX;
	
	@Positive
	private int coordY;

	public static PoiDTO create(Poi p) {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(p, PoiDTO.class);
	}
}
