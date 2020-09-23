package com.pi.dh.domain.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pi.dh.domain.model.Professor;
import com.pi.dh.domain.repository.ProfessorRepository;

@Service
public class ProfessorService {

	@Autowired
	private ProfessorRepository professorRepository;
	
	@Transactional
	public void salvar(Professor professor) {
		professorRepository.save(professor);
	}
	
	public List<Professor> listar() {
		return professorRepository.findAll();
	}
	
	public Professor buscarPorId(Long id) {
		return professorRepository.findById(id).get();
	}
	
	@Transactional
	public void excluir(Long id) {
		professorRepository.deleteById(id);
	}
	
	@Transactional
	public void atualizar(Professor professor, Long id) {
		Professor prof = professorRepository.findById(id).get();
		
		prof.setPessoa(professor.getPessoa());
		prof.setDepartamento(professor.getDepartamento());
		
		professorRepository.save(prof);
	}
}
