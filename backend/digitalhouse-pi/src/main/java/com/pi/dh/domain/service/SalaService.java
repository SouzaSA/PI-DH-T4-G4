package com.pi.dh.domain.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pi.dh.domain.model.Sala;
import com.pi.dh.domain.model.enums.Departamentos;
import com.pi.dh.domain.repository.SalaRepository;
import com.pi.dh.dto.SalaDTO;
import com.pi.dh.mapper.SalaMapper;
import com.pi.dh.request.SalaRequest;

@Service
public class SalaService {

	@Autowired
	private SalaRepository salaRepository;
	
	@Autowired
	private SalaMapper mapper;
	
	@Transactional
	public void salvar(SalaRequest salaRequest) {
		salaRepository.save(mapper.requestToModel(salaRequest));
	}
	
	public List<SalaDTO> listar() {
		//return salaRepository.findAll();
		return salaRepository.findAll()
				.stream()
				.map(sal -> mapper.modelToDTO(sal))
				.collect(Collectors.toList());
	}
	
	public SalaDTO buscarPorId(Long id) {
		return mapper.modelToDTO(salaRepository.findById(id).get());
	}
	
	@Transactional
	public void excluir(Long id) {
		salaRepository.deleteById(id);
	}
	
	@Transactional
	public void atualizar(SalaRequest salaRequest, Long id) {
		Sala sl = salaRepository.findById(id).get();
		sl.setAndar(salaRequest.getAndar());
		sl.setCapacidade(salaRequest.getCapacidade());
		sl.setDepartamento(Departamentos.toEnum(salaRequest.getDepartamento()));
		sl.setNumero(salaRequest.getNumero());
		
		salaRepository.save(sl);
	}
}
