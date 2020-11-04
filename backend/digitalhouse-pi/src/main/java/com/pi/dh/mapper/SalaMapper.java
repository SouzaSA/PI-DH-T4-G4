package com.pi.dh.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pi.dh.domain.model.Sala;
import com.pi.dh.dto.SalaDTO;
import com.pi.dh.request.SalaRequest;

@Component
public class SalaMapper {

	@Autowired
	private ModelMapper modelMapper;
	
	public SalaDTO modelToDTO(Sala sala) {
		return modelMapper.map(sala, SalaDTO.class);
	}
	
	public Sala requestToModel(SalaRequest salaRequest) {
		return modelMapper.map(salaRequest, Sala.class);
	}
}
