package com.pi.dh.domain.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pi.dh.domain.model.DisciplinaOferecida;
import com.pi.dh.domain.model.enums.DiaSemana;
import com.pi.dh.domain.model.enums.Hora;
import com.pi.dh.domain.repository.DisciplinaOferecidaRepository;
import com.pi.dh.domain.repository.DisciplinaRepository;
import com.pi.dh.domain.repository.ProfessorRepository;
import com.pi.dh.domain.repository.SalaRepository;
import com.pi.dh.dto.DisciplinaOferecidaDTO;
import com.pi.dh.mapper.DisciplinaOferecidaMapper;
import com.pi.dh.request.DisciplinaOferecidaRequest;

@Service
public class DisciplinaOferecidaService {

	@Autowired
	private DisciplinaOferecidaRepository disciplinaOferecidaRepository;
	
	@Autowired
	private ProfessorRepository professorRepository;
	
	@Autowired
	private DisciplinaRepository disciplinaRepository;
	
	@Autowired
	private SalaRepository salaRepository;
	
	@Autowired
	private DisciplinaOferecidaMapper mapper;
	
	@Transactional
	public void salvar(DisciplinaOferecidaRequest disciplinaOferecidaRequest) {
		
		DisciplinaOferecida disciplinaOferecida = mapper.requestToModel(disciplinaOferecidaRequest);
		
		disciplinaOferecida.setDisciplinaOferecidaId(null);
		disciplinaOferecida.setProfessor(professorRepository.findById(disciplinaOferecida.getProfessor().getProfessorId()).get());
		disciplinaOferecida.setDisciplina(disciplinaRepository.findById(disciplinaOferecida.getDisciplina().getDisciplinaId()).get());
		disciplinaOferecida.setSala(salaRepository.findById(disciplinaOferecida.getSala().getSalaId()).get());
		disciplinaOferecida.setHorario(Hora.toEnum(disciplinaOferecidaRequest.getHorario()));
		disciplinaOferecida.setDiaSemana(DiaSemana.toEnum(disciplinaOferecidaRequest.getDiaSemana()));
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
