package com.pi.dh.domain.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pi.dh.domain.model.DisciplinaOferecida;
import com.pi.dh.domain.repository.DisciplinaOferecidaRepository;

@Service
public class DisciplinaOferecidaService {

	@Autowired
	private DisciplinaOferecidaRepository disciplinaOferecidaRepository;
	
	@Transactional
	public void salvar(DisciplinaOferecida disciplinaOferecida) {
		disciplinaOferecidaRepository.save(disciplinaOferecida);
	}
	
	public List<DisciplinaOferecida> listar() {
		return disciplinaOferecidaRepository.findAll();
	}
	
	public DisciplinaOferecida buscarPorId(Long id) {
		return disciplinaOferecidaRepository.findById(id).get();
	}
	
	@Transactional
	public void excluir(Long id) {
		disciplinaOferecidaRepository.deleteById(id);
	}
	
	@Transactional
	public void atualizar(DisciplinaOferecida disciplinaOferecida, Long id) {
		DisciplinaOferecida discO = disciplinaOferecidaRepository.findById(id).get();
		
		discO.setHorario(disciplinaOferecida.getHorario());
		discO.setDiaSemana(disciplinaOferecida.getDiaSemana());
		discO.setSemestre(disciplinaOferecida.getSemestre());
		discO.setAno(disciplinaOferecida.getAno());
		discO.setTurma(disciplinaOferecida.getTurma());
		discO.setProfessor(disciplinaOferecida.getProfessor());
		discO.setDisciplina(disciplinaOferecida.getDisciplina());
		discO.setSala(disciplinaOferecida.getSala());



		
		disciplinaOferecidaRepository.save(discO);
	}
}
