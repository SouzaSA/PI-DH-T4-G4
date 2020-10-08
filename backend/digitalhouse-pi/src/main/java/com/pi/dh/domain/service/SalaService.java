package com.pi.dh.domain.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pi.dh.domain.model.Sala;
import com.pi.dh.domain.repository.SalaRepository;

@Service
public class SalaService {

	@Autowired
	private SalaRepository salaRepository;
	
	@Transactional
	public void salvar(Sala sala) {
		salaRepository.save(sala);
	}
	
	public List<Sala> listar() {
		return salaRepository.findAll();
	}
	
	public Sala buscarPorId(Long id) {
		return salaRepository.findById(id).get();
	}
	
	@Transactional
	public void excluir(Long id) {
		salaRepository.deleteById(id);
	}
	
	@Transactional
	public void atualizar(Sala sala, Long id) {
		Sala sl = salaRepository.findById(id).get();
		sl.setAndar(sala.getAndar());
		sl.setCapacidade(sala.getCapacidade());
		sl.setDepartamento(sala.getDepartamento());
		sl.setNumero(sala.getNumero());
		
		salaRepository.save(sl);
	}
}
