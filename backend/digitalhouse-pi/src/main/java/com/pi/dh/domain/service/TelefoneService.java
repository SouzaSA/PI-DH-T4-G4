package com.pi.dh.domain.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pi.dh.domain.model.Telefone;
import com.pi.dh.domain.repository.TelefoneRepository;

@Service
public class TelefoneService {

	@Autowired
	private TelefoneRepository telefoneRepository;
	
	@Transactional
	public void salvar(Telefone telefone) {
		telefoneRepository.save(telefone);
	}
	
	public List<Telefone> listar() {
		return telefoneRepository.findAll();
	}
	
	public Telefone buscarPorId(Long id) {
		return telefoneRepository.findById(id).get();
	}
	
	@Transactional
	public void excluir(Long id) {
		telefoneRepository.deleteById(id);
	}
	
	@Transactional
	public void atualizar(Telefone telefone, Long id) {
		Telefone tel = telefoneRepository.findById(id).get();
		
		tel.setTelefone(telefone.getTelefone());

		
		telefoneRepository.save(tel);
	}
}
