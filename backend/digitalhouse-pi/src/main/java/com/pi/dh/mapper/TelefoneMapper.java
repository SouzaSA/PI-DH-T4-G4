package com.pi.dh.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pi.dh.domain.model.Telefone;
import com.pi.dh.dto.TelefoneDTO;
import com.pi.dh.request.TelefoneRequest;

@Component
public class TelefoneMapper {
	
	@Autowired
	private ModelMapper modelMapper;
	
	public TelefoneDTO modelToDTO(Telefone telefone) {
		return modelMapper.map(telefone, TelefoneDTO.class);
	}
	
	public Telefone requestToModel(TelefoneRequest telefoneRequest) {
		return modelMapper.map(telefoneRequest, Telefone.class);
	}

}
