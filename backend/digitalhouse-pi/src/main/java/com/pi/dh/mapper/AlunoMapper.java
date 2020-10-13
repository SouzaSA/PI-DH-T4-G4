package com.pi.dh.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pi.dh.domain.model.Aluno;
import com.pi.dh.dto.AlunoDTO;
import com.pi.dh.request.AlunoRequest;

@Component
public class AlunoMapper {

	@Autowired
	private ModelMapper modelMapper;
	
	public AlunoDTO modelToDTO(Aluno aluno) {
		return modelMapper.map(aluno, AlunoDTO.class);
	}
	
	public Aluno requestToModel(AlunoRequest alunoRequest) {
		return modelMapper.map(alunoRequest, Aluno.class);
	}
}
