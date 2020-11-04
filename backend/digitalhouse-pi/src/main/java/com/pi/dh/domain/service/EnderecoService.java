package com.pi.dh.domain.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pi.dh.domain.model.Endereco;
import com.pi.dh.domain.repository.EnderecoRepository;
import com.pi.dh.dto.EnderecoDTO;
import com.pi.dh.mapper.EnderecoMapper;
import com.pi.dh.request.EnderecoRequest;

@Service
public class EnderecoService {

	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@Autowired
	private EnderecoMapper mapper;
	
	@Transactional
	public void salvar(EnderecoRequest endereco) {
		enderecoRepository.save(mapper.requestToModel(endereco));
	}
	
	public List<EnderecoDTO> listar() {
		//return enderecoRepository.findAll();
		return enderecoRepository.findAll()
				.stream()
				.map(end -> mapper.modelToDTO(end))
				.collect(Collectors.toList());
		
	}
	
	public Endereco buscarPorId(Long id) {
		return enderecoRepository.findById(id).get();
	}
	
	@Transactional
	public void excluir(Long id) {
		enderecoRepository.deleteById(id);
	}
	
	@Transactional
	public void atualizar(Endereco endereco, Long id) {
		Endereco end = enderecoRepository.findById(id).get();
		end.setId(endereco.getId());
		end.setCep(endereco.getCep());
		end.setRua(endereco.getRua());
		end.setNumero(endereco.getNumero());
		end.setComplemento(endereco.getComplemento());
		end.setBairro(endereco.getBairro());
		end.setCidade(endereco.getCidade());
		end.setEstado(endereco.getEstado());
		
		enderecoRepository.save(end);
	}
}
