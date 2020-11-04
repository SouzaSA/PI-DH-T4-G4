package com.pi.dh.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pi.dh.domain.model.DisciplinaOferecida;
import com.pi.dh.dto.DisciplinaOferecidaDTO;
import com.pi.dh.request.DisciplinaOferecidaRequest;

@Component
public class DisciplinaOferecidaMapper {
	
	@Autowired
	private ModelMapper modelMapper;
	
	public DisciplinaOferecidaDTO modelToDTO(DisciplinaOferecida disciplinaOferecida) {
		return modelMapper.map(disciplinaOferecida, DisciplinaOferecidaDTO.class);
	}
	
	public DisciplinaOferecida requestToModel(DisciplinaOferecidaRequest disciplinaOferecidaRequest) {
		return modelMapper.map(disciplinaOferecidaRequest, DisciplinaOferecida.class);
	}

}
