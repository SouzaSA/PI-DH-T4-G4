package com.pi.dh.domain.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;

import com.pi.dh.domain.model.Disciplina;
import com.pi.dh.domain.repository.DisciplinaRepository;

@Service
public class DisciplinaService {

	@Autowired
	private DisciplinaRepository disciplinaRepository;
	
	@Transactional
	public void salvar(Disciplina disciplina) {
		disciplinaRepository.save(disciplina);
	}
	
	public List<Disciplina> listar() {
		return disciplinaRepository.findAll();
	}
	
	public Disciplina buscarPorId(Long id) {
		return disciplinaRepository.findById(id).get();
	}
	
	@DeleteMapping("/{id}")
	public void excluir(Long id) {
		disciplinaRepository.deleteById(id);
	}
	
	@Transactional
	public void atualizar(Disciplina disciplina, Long id) {
		Disciplina disc = disciplinaRepository.findById(id).get();
		
		disc.setNome(disciplina.getNome());
		disc.setEmenta(disciplina.getEmenta());
		disc.setCreditos(disciplina.getCreditos());
		disc.setCodigo(disciplina.getCodigo());
		disc.setSemestreIdeal(disciplina.getSemestreIdeal());

		
		disciplinaRepository.save(disc);
	}
}
