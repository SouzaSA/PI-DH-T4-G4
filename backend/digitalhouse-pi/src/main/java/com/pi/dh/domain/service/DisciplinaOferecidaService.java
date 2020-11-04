package com.pi.dh.domain.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pi.dh.domain.model.DisciplinaOferecida;
import com.pi.dh.domain.repository.DisciplinaOferecidaRepository;
import com.pi.dh.dto.DisciplinaOferecidaDTO;
import com.pi.dh.mapper.DisciplinaOferecidaMapper;

@Service
public class DisciplinaOferecidaService {

	@Autowired
	private DisciplinaOferecidaRepository disciplinaOferecidaRepository;
	
	@Autowired
	private DisciplinaOferecidaMapper mapper;
	
	@Transactional
	public void salvar(DisciplinaOferecida disciplinaOferecida) {
		disciplinaOferecidaRepository.save(disciplinaOferecida);
	}
	
	public List<DisciplinaOferecidaDTO> listar() {
		//return disciplinaOferecidaRepository.findAll();
		return disciplinaOferecidaRepository.findAll()
				.stream()
				.map(pess -> mapper.modelToDTO(pess))
				.collect(Collectors.toList());
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
