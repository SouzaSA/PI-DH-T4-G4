package com.pi.dh.domain.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pi.dh.domain.model.Pessoa;
import com.pi.dh.domain.repository.PessoaRepository;

@Service
public class PessoaService {

	@Autowired
	private PessoaRepository pessoaRepository;
	
	@Transactional
	public void salvar(Pessoa pessoa) {
		pessoaRepository.save(pessoa);
	}
	
	public List<Pessoa> listar() {
		return pessoaRepository.findAll();
	}
	
	public Pessoa buscarPorId(Long id) {
		return pessoaRepository.findById(id).get();
	}
	
	@Transactional
	public void excluir(Long id) {
		pessoaRepository.deleteById(id);
	}
	
	@Transactional
	public void atualizar(Pessoa pessoa, Long id) {
		Pessoa pess = pessoaRepository.findById(id).get();
		
		pess.setCep(pessoa.getCep());
		pess.setRua(pessoa.getRua());
		pess.setNumero(pessoa.getNumero());
		pess.setBairro(pessoa.getBairro());
		pess.setCidade(pessoa.getCidade());
		pess.setEstado(pessoa.getEstado());
		pess.setComplemento(pessoa.getComplemento());
		pess.setSobrenome(pessoa.getSobrenome());
		pess.setNome(pessoa.getNome());
		pess.setEmail(pessoa.getEmail());
		pess.setPassword(pessoa.getPassword());
		pess.setFoto(pessoa.getFoto());
		
		pessoaRepository.save(pess);
	}
}
