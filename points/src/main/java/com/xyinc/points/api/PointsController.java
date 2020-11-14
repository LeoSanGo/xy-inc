package com.xyinc.points.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xyinc.points.api.domain.PoiService;

@RestController
@RequestMapping("/points")
public class PointsController {
	
	@Autowired
	private PoiService service;
	
	@GetMapping()
	public ResponseEntity get() {
		return ResponseEntity.ok(service.getPois()); //Verificar o retorno do Json
	}
	
	

}
