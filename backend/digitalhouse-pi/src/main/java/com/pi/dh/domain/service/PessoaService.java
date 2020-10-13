package com.pi.dh.domain.service;

import java.time.OffsetDateTime;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pi.dh.domain.model.Pessoa;
import com.pi.dh.domain.repository.EnderecoRepository;
import com.pi.dh.domain.repository.PessoaRepository;
import com.pi.dh.dto.PessoaDTO;
import com.pi.dh.mapper.PessoaMapper;
import com.pi.dh.request.PessoaRequest;

@Service
public class PessoaService {

	@Autowired
	private PessoaRepository pessoaRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@Autowired
	private PessoaMapper mapper;
		
	@Transactional
	public PessoaDTO salvar(PessoaRequest pessoaRequest) {
		
		Pessoa pessoa = mapper.requestToModel(pessoaRequest);
		
		pessoa.setPessoaId(null);
		pessoa.setDataCadastro(OffsetDateTime.now());
		enderecoRepository.save(pessoa.getEndereco());
		
	    return mapper.modelToDTO( pessoaRepository.save(pessoa) );
	    
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
		
		pess.setSobrenome(pessoa.getSobrenome());
		pess.setNome(pessoa.getNome());
		pess.setEmail(pessoa.getEmail());
		pess.setPassword(pessoa.getPassword());
		pess.setFoto(pessoa.getFoto());
		
		pessoaRepository.save(pess);
	}
}
