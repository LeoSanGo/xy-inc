package com.xyinc.points.api;

import java.net.URI;

import javax.validation.ConstraintDeclarationException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.xyinc.points.domain.Poi;
import com.xyinc.points.domain.dto.PoiDTO;
import com.xyinc.points.service.PoiService;

@RestController
@RequestMapping("/points")
public class PointsController {
	
	@Autowired
	private PoiService service;
	
	@GetMapping()
	public ResponseEntity get() {
		return ResponseEntity.ok(service.getPois());
	}
	
	@PostMapping("/insert")
	public ResponseEntity post(@Valid @RequestBody Poi poi, BindingResult br) {
		if (br.hasErrors()) {
			throw new ConstraintDeclarationException(br.getAllErrors().get(0).getDefaultMessage());
		}
		try {
			PoiDTO p =  service.insert(poi);
			
			URI location = getUri(p.getId());	
			return ResponseEntity.created(location).build();
		} catch (Exception ex) {
			return ResponseEntity.badRequest().build();
		}	
	}
	
	private URI getUri(Long id) {
		return ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(id).toUri();
	}
	
	
	@GetMapping("/search")
	private ResponseEntity getPoisByProximity(@RequestParam(value = "coordX", required = true) int coordX, 
			@RequestParam(value = "coordY", required = true) int coordY, @RequestParam(value = "distance", required = true) int distance) {
		return ResponseEntity.ok(service.calcDistance(coordX, coordY, distance));
	}

}
