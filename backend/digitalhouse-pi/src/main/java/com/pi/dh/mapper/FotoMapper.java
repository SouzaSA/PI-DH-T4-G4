package com.pi.dh.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pi.dh.domain.model.Foto;
import com.pi.dh.dto.FotoDTO;
import com.pi.dh.request.FotoRequest;

@Component
public class FotoMapper {

	@Autowired
	private ModelMapper modelMapper;

	public Foto requestToModel(FotoRequest fotoRequest) {
		return modelMapper.map(fotoRequest, Foto.class);
	}

	public FotoDTO modelToDTO(Foto foto) {
		return modelMapper.map(foto, FotoDTO.class);
	}
}
