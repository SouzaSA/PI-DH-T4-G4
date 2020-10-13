package com.pi.dh.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pi.dh.domain.model.Curso;
import com.pi.dh.dto.CursoDTO;
import com.pi.dh.request.CursoRequest;

@Component
public class CursoMapper {

	@Autowired
	private ModelMapper modelMapper;
	
	public CursoDTO modelToDTO(Curso curso) {
		return modelMapper.map(curso, CursoDTO.class);
	}
	
	public Curso requestToModel(CursoRequest cursoRequest) {
		return modelMapper.map(cursoRequest, Curso.class);
	}
}
