package com.pi.dh.domain.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.pi.dh.domain.model.Administrador;
import com.pi.dh.domain.repository.AdministradorRepository;
import com.pi.dh.domain.repository.EnderecoRepository;
import com.pi.dh.domain.repository.PessoaRepository;
import com.pi.dh.dto.AdministradorDTO;
import com.pi.dh.mapper.AdministradorMapper;
import com.pi.dh.request.AdministradorRequest;

@Service
public class AdministradorService {

	@Autowired
	private AdministradorRepository administradorRepository;
	
	@Autowired 
	private PessoaRepository pessoaRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@Autowired
	private AdministradorMapper mapper;
	
	@Transactional
	public AdministradorDTO salvar(@RequestBody AdministradorRequest administradorRequest) {
	
		Administrador admin = mapper.requestToModel(administradorRequest);
		
		enderecoRepository.save(admin.getPessoa().getEndereco());
		pessoaRepository.save(admin.getPessoa());
		
		admin.setAdministradorId(null);
		
	    return mapper.modelToDTO( administradorRepository.save(admin) );
	}
	
	public List<AdministradorDTO> listar() {
		//return administradorRepository.findAll();
		return administradorRepository.findAll()
				.stream()
				.map(pess -> mapper.modelToDTO(pess))
				.collect(Collectors.toList());
	}
	
	public AdministradorDTO buscarPorId(Long id) {
		return mapper.modelToDTO(administradorRepository.findById(id).get());
	}
	
	@Transactional
	public void excluir(Long id) {
		administradorRepository.deleteById(id);
	}
	
	@Transactional
	public void atualizar(AdministradorRequest administrador, Long id) {
		Administrador adm = administradorRepository.findById(id).get();
		
		adm.setPessoa(mapper.requestToModel(administrador).getPessoa());
		
		administradorRepository.save(adm);
	}
}
