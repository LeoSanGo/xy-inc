package com.xyinc.points.api.domain;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.xyinc.points.api.domain.dto.PoiDTO;
@Service
public class PoiService {
	
	@Autowired
	private PoiRepository rep;
	
	public List<PoiDTO> getPois() {
		return rep.findAll().stream().map(PoiDTO::create).collect(Collectors.toList());
	}
	
	public PoiDTO insert(Poi poi) {
		Assert.isNull(poi.getId(), "Não foi possivel inserir o registro");
		return PoiDTO.create(rep.save(poi));
		
	}

}
