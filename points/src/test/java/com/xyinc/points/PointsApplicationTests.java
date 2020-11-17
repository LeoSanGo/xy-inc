package com.xyinc.points;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.xyinc.points.domain.Poi;
import com.xyinc.points.domain.dto.PoiDTO;
import com.xyinc.points.service.PoiService;

@SpringBootTest
class PointsApplicationTests {
	
	@Autowired
	private PoiService service;	
	
	@Test
	public void testInsert() {
		Poi poi = new Poi();
		poi.setName("Lago");
		poi.setCoordX(13);
		poi.setCoordY(66);
		
		PoiDTO pDTO = service.insert(poi);
		
		assertNotNull(pDTO);
	}
	
	@Test
	public void testList() {
		List<PoiDTO> poiDTO = service.getPois();
		
		assertEquals(7, poiDTO.size());
	}	
	
	@Test
	public void testValidation() {
		Poi poi = new Poi();
		poi.setName("LagoX");
		poi.setCoordX(15);
		poi.setCoordY(18);
		
		service.insert(poi);
		
        assertTrue(poi.getCoordX() > 0);
        assertTrue(poi.getCoordY() > 0);
        assertFalse(poi.getName().isEmpty());
	}
	
	
}
