package com.xyinc.points.api.domain;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xyinc.points.api.domain.dto.PoiDTO;
@Service
public class PoiService {
	
	@Autowired
	private PoiRepository rep;
	
	public List<PoiDTO> getPois() {
		return rep.findAll().stream().map(PoiDTO::create).collect(Collectors.toList());
	}

}
