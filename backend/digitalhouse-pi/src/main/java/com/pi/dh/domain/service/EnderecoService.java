package com.pi.dh.domain.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pi.dh.domain.model.Endereco;
import com.pi.dh.domain.repository.EnderecoRepository;

@Service
public class EnderecoService {

	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@Transactional
	public void salvar(Endereco endereco) {
		enderecoRepository.save(endereco);
	}
	
	public List<Endereco> listar() {
		return enderecoRepository.findAll();
	}
	
	public Endereco buscarPorId(Integer id) {
		return enderecoRepository.findById(id).get();
	}
	
	@Transactional
	public void excluir(Integer id) {
		enderecoRepository.deleteById(id);
	}
	
	@Transactional
	public void atualizar(Endereco endereco, Integer id) {
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
