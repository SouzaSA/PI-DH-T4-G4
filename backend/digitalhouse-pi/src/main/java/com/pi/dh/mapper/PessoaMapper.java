package com.pi.dh.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pi.dh.domain.model.Pessoa;
import com.pi.dh.dto.PessoaDTO;
import com.pi.dh.request.PessoaRequest;

@Component
public class PessoaMapper {

	@Autowired
	private ModelMapper modelMapper;
	
	public PessoaDTO modelToDTO(Pessoa pessoa) {
		return modelMapper.map(pessoa, PessoaDTO.class);
	}
	
	public Pessoa requestToModel(PessoaRequest pessoaRequest) {
		return modelMapper.map(pessoaRequest, Pessoa.class);
	}
}
