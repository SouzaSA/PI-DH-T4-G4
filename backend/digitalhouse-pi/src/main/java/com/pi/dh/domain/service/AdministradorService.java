package com.pi.dh.domain.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.pi.dh.domain.model.Administrador;
import com.pi.dh.domain.repository.AdministradorRepository;

@Service
public class AdministradorService {

	@Autowired
	private AdministradorRepository administradorRepository;
	
	@Transactional
	public void salvar(@RequestBody Administrador administrador) {
		administradorRepository.save(administrador);
	}
	
	public List<Administrador> listar() {
		return administradorRepository.findAll();
	}
	
	public Administrador buscarPorId(Long id) {
		return administradorRepository.findById(id).get();
	}
	
	@Transactional
	public void excluir(Long id) {
		administradorRepository.deleteById(id);
	}
	
	@Transactional
	public void atualizar(Administrador administrador, Long id) {
		Administrador adm = administradorRepository.findById(id).get();
		
		adm.setPessoa(administrador.getPessoa());
		
		administradorRepository.save(adm);
	}
}
