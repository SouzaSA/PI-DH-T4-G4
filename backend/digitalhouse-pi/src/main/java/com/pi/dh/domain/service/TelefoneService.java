package com.pi.dh.domain.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pi.dh.domain.model.Telefone;
import com.pi.dh.domain.repository.TelefoneRepository;
import com.pi.dh.dto.TelefoneDTO;
import com.pi.dh.mapper.TelefoneMapper;
import com.pi.dh.request.TelefoneRequest;

@Service
public class TelefoneService {

	@Autowired
	private TelefoneRepository telefoneRepository;
	
	@Autowired
	private TelefoneMapper mapper;
	
	@Transactional
	public void salvar(TelefoneRequest telefoneRequest) {
		telefoneRepository.save(mapper.requestToModel(telefoneRequest));
	}
	
	public List<TelefoneDTO> listar() {
		//return telefoneRepository.findAll();
		return telefoneRepository.findAll()
				.stream()
				.map(pess -> mapper.modelToDTO(pess))
				.collect(Collectors.toList());
	}
	
	public TelefoneDTO buscarPorId(Long id) {
		return mapper.modelToDTO(telefoneRepository.findById(id).get());
	}
	
	@Transactional
	public void excluir(Long id) {
		telefoneRepository.deleteById(id);
	}
	
	@Transactional
	public void atualizar(TelefoneRequest telefoneRequest, Long id) {
		Telefone tel = telefoneRepository.findById(id).get();
		
		tel.setTelefone(mapper.requestToModel(telefoneRequest).getTelefone());

		
		telefoneRepository.save(tel);
	}
}
