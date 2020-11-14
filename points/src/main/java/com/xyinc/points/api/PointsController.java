package com.xyinc.points.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/points")
public class PointsController {
	
	@GetMapping()
	public String get() {
		return "API via gets";
	}
	
	

}
