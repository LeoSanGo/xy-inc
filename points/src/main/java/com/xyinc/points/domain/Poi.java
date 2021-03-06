package com.xyinc.points.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

import lombok.Data;

@Entity
@Data
public class Poi {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	private String name;
	
	@Positive(message = "Coordenada x deve ser maior que 0")
	private int coordX;
	
	@Positive(message = "Coordenada y deve ser maior que 0")
	private int coordY;

}
