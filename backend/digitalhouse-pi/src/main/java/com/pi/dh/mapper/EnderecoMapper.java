package com.pi.dh.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pi.dh.domain.model.Endereco;
import com.pi.dh.dto.EnderecoDTO;
import com.pi.dh.request.EnderecoRequest;

@Component
public class EnderecoMapper {
	
	@Autowired
	private ModelMapper modelMapper;
	
	public EnderecoDTO modelToDTO(Endereco endereco) {
		return modelMapper.map(endereco, EnderecoDTO.class);
	}
	
	public Endereco requestToModel(EnderecoRequest enderecoRequest) {
		return modelMapper.map(enderecoRequest, Endereco.class);
	}
}
