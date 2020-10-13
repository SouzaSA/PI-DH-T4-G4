package com.pi.dh.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pi.dh.domain.model.Nota;
import com.pi.dh.dto.NotaDTO;
import com.pi.dh.request.NotaRequest;

@Component
public class NotaMapper {

	@Autowired
	private ModelMapper modelMapper;
	
	public NotaDTO modelToDTO(Nota nota) {
		return modelMapper.map(nota, NotaDTO.class);
	}
	
	public Nota requestToModel(NotaRequest notaRequest) {
		return modelMapper.map(notaRequest, Nota.class);
	}
}
