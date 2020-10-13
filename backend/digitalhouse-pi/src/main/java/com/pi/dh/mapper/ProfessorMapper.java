package com.pi.dh.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pi.dh.domain.model.Professor;
import com.pi.dh.dto.ProfessorDTO;
import com.pi.dh.request.ProfessorRequest;

@Component
public class ProfessorMapper {

	@Autowired
	private ModelMapper modelMapper;
	
	public ProfessorDTO modelToDTO(Professor professor) {
		return modelMapper.map(professor, ProfessorDTO.class);
	}
	
	public Professor requestToModel(ProfessorRequest professorRequest) {
		return modelMapper.map(professorRequest, Professor.class);
	}
}
