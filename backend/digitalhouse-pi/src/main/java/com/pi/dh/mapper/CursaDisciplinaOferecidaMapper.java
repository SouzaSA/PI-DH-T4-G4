package com.pi.dh.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pi.dh.domain.model.CursaDisciplinaOferecida;
import com.pi.dh.dto.CursaDisciplinaOferecidaDTO;
import com.pi.dh.request.CursaDisciplinaOferecidaRequest;

@Component
public class CursaDisciplinaOferecidaMapper {

	@Autowired
	private ModelMapper modelMapper;
	
	public CursaDisciplinaOferecidaDTO modelToDTO(CursaDisciplinaOferecida cursaDisciplinaOferecida) {
		return modelMapper.map(cursaDisciplinaOferecida, CursaDisciplinaOferecidaDTO.class);
	}
	
	public CursaDisciplinaOferecida requestToModel(CursaDisciplinaOferecidaRequest cursaDisciplinaOferecidaRequest) {
		return modelMapper.map(cursaDisciplinaOferecidaRequest, CursaDisciplinaOferecida.class);
	}
}
