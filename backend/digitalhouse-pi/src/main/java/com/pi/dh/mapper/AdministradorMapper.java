package com.pi.dh.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pi.dh.domain.model.Administrador;
import com.pi.dh.dto.AdministradorDTO;
import com.pi.dh.request.AdministradorRequest;

@Component
public class AdministradorMapper {

	@Autowired
	private ModelMapper modelMapper;
	
	public AdministradorDTO modelToDTO(Administrador administrador) {
		return modelMapper.map(administrador, AdministradorDTO.class);
	}
	
	public Administrador requestToModel(AdministradorRequest administradorRequest) {
		return modelMapper.map(administradorRequest, Administrador.class);
	}
}
