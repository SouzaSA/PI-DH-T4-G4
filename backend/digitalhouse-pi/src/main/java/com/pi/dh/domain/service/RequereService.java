package com.pi.dh.domain.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pi.dh.domain.model.Requere;
import com.pi.dh.domain.repository.RequereRepository;

@Service
public class RequereService {

	@Autowired
	private RequereRepository requereRepository;
	
	@Transactional
	public void salvar(Requere requere) {
		requereRepository.save(requere);
	}
	
	public List<Requere> listar() {
		return requereRepository.findAll();
	}
	
	public Requere buscarPorId(Long id) {
		return requereRepository.findById(id).get();
	}
	
	@Transactional
	public void excluir(Long id) {
		requereRepository.deleteById(id);
	}
	
	@Transactional
	public void atualizar(Requere requere, Long id) {
		Requere req = requereRepository.findById(id).get();
		
		req.setDisciplina(requere.getDisciplina());
		req.setRequerida(requere.getRequerida());

		
		requereRepository.save(req);
	}
}
