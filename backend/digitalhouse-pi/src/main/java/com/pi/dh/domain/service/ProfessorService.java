package com.pi.dh.domain.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.pi.dh.domain.model.Professor;
import com.pi.dh.domain.repository.EnderecoRepository;
import com.pi.dh.domain.repository.PessoaRepository;
import com.pi.dh.domain.repository.ProfessorRepository;
import com.pi.dh.dto.ProfessorDTO;
import com.pi.dh.mapper.ProfessorMapper;
import com.pi.dh.request.ProfessorRequest;

@Service
public class ProfessorService {

	@Autowired
	private ProfessorRepository professorRepository;
		
	@Autowired 
	private PessoaRepository pessoaRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@Autowired
	private ProfessorMapper mapper;
	
	@Transactional
	public ProfessorDTO salvar(@RequestBody ProfessorRequest professorRequest) {

		Professor professor = mapper.requestToModel(professorRequest);
		
		enderecoRepository.save(professor.getPessoa().getEndereco());
		pessoaRepository.save(professor.getPessoa());
		
		professor.setProfessor_id(null);
	    return mapper.modelToDTO( professorRepository.save(professor) );
	}
	
	public List<ProfessorDTO> listar() {
		//return professorRepository.findAll();
		return professorRepository.findAll()
				.stream()
				.map(prof -> mapper.modelToDTO(prof))
				.collect(Collectors.toList());
	}
	
	public ProfessorDTO buscarPorId(Long id) {
		return mapper.modelToDTO(professorRepository.findById(id).get());
	}
	
	@Transactional
	public void excluir(Long id) {
		professorRepository.deleteById(id);
	}
	
	@Transactional
	public void atualizar(ProfessorRequest professor, Long id) {
		Professor prof = professorRepository.findById(id).get();
		
		prof.setPessoa(mapper.requestToModel(professor).getPessoa());
		prof.setDepartamento(mapper.requestToModel(professor).getDepartamento());
		
		professorRepository.save(prof);
	}
}
