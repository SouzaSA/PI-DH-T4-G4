package com.pi.dh.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pi.dh.domain.model.Disciplina;
import com.pi.dh.dto.DisciplinaDTO;
import com.pi.dh.request.DisciplinaRequest;

@Component
public class DisciplinaMapper {

	@Autowired
	private ModelMapper modelMapper;
	
	public DisciplinaDTO modelToDTO(Disciplina disciplina) {
		return modelMapper.map(disciplina, DisciplinaDTO.class);
	}
	
	public Disciplina requestToModel(DisciplinaRequest disciplinaRequest) {
		return modelMapper.map(disciplinaRequest, Disciplina.class);
	}
}
