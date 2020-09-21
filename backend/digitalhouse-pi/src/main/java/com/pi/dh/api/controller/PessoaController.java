package com.pi.dh.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pi.dh.domain.model.Pessoa;
import com.pi.dh.domain.repository.PessoaRepository;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {

	@Autowired
	private PessoaRepository pessoaRepository;
	
	@PostMapping
	public void salvar(@RequestBody Pessoa pessoa) {
		pessoaRepository.save(pessoa);
	}
	
	@GetMapping
	public List<Pessoa> listar() {
		return pessoaRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Pessoa buscar(@PathVariable Long id) {
		return pessoaRepository.findById(id).get();
	}
	
	@DeleteMapping("/{id}")
	public void excluir(@PathVariable Long id) {
		pessoaRepository.deleteById(id);
	}
	
	@PutMapping("/{id}")
	public void atualizar(@RequestBody Pessoa pessoa, @PathVariable Long id) {
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
