package com.pi.dh.domain.service;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pi.dh.domain.model.CursaDisciplinaOferecida;
import com.pi.dh.domain.repository.CursaDisciplinaOferecidaRepository;
import com.pi.dh.dto.CursaDisciplinaOferecidaDTO;
import com.pi.dh.mapper.CursaDisciplinaOferecidaMapper;
import com.pi.dh.request.CursaDisciplinaOferecidaRequest;

@Service
public class CursaDisciplinaOferecidaService {

	@Autowired
	private CursaDisciplinaOferecidaRepository cursaDisciplinaOferecidaRepository;
	
	@Autowired
	private CursaDisciplinaOferecidaMapper mapper;
	
	@Transactional
	public void salvar(CursaDisciplinaOferecida cursaDisciplinaOferecida) {
		cursaDisciplinaOferecida.setDataInscricao(OffsetDateTime.now());
		cursaDisciplinaOferecidaRepository.save(cursaDisciplinaOferecida);
	}
	
	public List<CursaDisciplinaOferecidaDTO> listar() {
		//return cursaDisciplinaOferecidaRepository.findAll();
		return cursaDisciplinaOferecidaRepository.findAll()
				.stream()
				.map(curdis -> mapper.modelToDTO(curdis))
				.collect(Collectors.toList());
	}
	
	public CursaDisciplinaOferecidaDTO buscarPorId(Long id) {
		return mapper.modelToDTO(cursaDisciplinaOferecidaRepository.findById(id).get());
	}
	
	public List<CursaDisciplinaOferecidaDTO> buscarPorProfessorId(Long professorId) {
		return cursaDisciplinaOferecidaRepository.findAllByProfessorId(professorId)
				.stream()
				.map(curdis -> mapper.modelToDTO(curdis))
				.collect(Collectors.toList());
	}
	
	public List<CursaDisciplinaOferecidaDTO> buscarPorAlunoId(Long alunoId) {
		return cursaDisciplinaOferecidaRepository.findAllByAlunoId(alunoId)
				.stream()
				.map(curdis -> mapper.modelToDTO(curdis))
				.collect(Collectors.toList());
	}
	
	public List<CursaDisciplinaOferecidaDTO> buscarPorDisciplinaId(Long disciplinaId){
		return cursaDisciplinaOferecidaRepository.findAllByDisciplinaId(disciplinaId)
				.stream()
				.map(disOf -> mapper.modelToDTO(disOf))
				.collect(Collectors.toList());
	}
	
	public List<CursaDisciplinaOferecidaDTO> buscarAllByDisciplinaIdAndProfessorId(Long disciplinaId, Long professorId){
		return cursaDisciplinaOferecidaRepository.findAllByDisciplinaIdAndProfessorId(disciplinaId, professorId)
				.stream()
				.map(disOf -> mapper.modelToDTO(disOf))
				.collect(Collectors.toList());
	}
		
	@Transactional
	public void excluir(Long id) {
		cursaDisciplinaOferecidaRepository.deleteById(id);
	}
	
	@Transactional
	public void atualizar(CursaDisciplinaOferecidaRequest cursaDisciplinaOferecida, Long id) {
		CursaDisciplinaOferecida cdo = cursaDisciplinaOferecidaRepository.findById(id).get();
		
		cdo.setDataInscricao(cursaDisciplinaOferecida.getDataInscricao());
		cdo.setDataDeferimento(cursaDisciplinaOferecida.getData_deferimento());
		cdo.setAluno(mapper.requestToModel(cursaDisciplinaOferecida).getAluno());
		cdo.setDisciplinaOferecida(mapper.requestToModel(cursaDisciplinaOferecida).getDisciplinaOferecida());

		
		cursaDisciplinaOferecidaRepository.save(cdo);
	}
}
