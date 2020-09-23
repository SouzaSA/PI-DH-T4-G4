package com.pi.dh.domain.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pi.dh.domain.model.Aluno;
import com.pi.dh.domain.repository.AlunoRepository;

@Service
public class AlunoService {

	@Autowired
	private AlunoRepository alunoRepository;
	
	@Transactional
	public void salvar(Aluno aluno) {
		alunoRepository.save(aluno);
	}
	
	public List<Aluno> listar() {
		return alunoRepository.findAll();
	}
	
	public Aluno buscarPorId(Long id) {
		return alunoRepository.findById(id).get();
	}
	
	@Transactional
	public void excluir(Long id) {
		alunoRepository.deleteById(id);
	}
	
	@Transactional
	public void atualizar(Aluno aluno, Long id) {
		Aluno al = alunoRepository.findById(id).get();
		
		al.setPessoa(aluno.getPessoa());
		al.setCurso(aluno.getCurso());
		
		alunoRepository.save(al);
	}
}
