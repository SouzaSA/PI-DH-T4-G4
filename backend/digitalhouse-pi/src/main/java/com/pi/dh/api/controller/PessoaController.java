package com.pi.dh.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pi.dh.domain.service.EnderecoService;
import com.pi.dh.domain.service.PessoaService;
import com.pi.dh.dto.PessoaDTO;
import com.pi.dh.request.PessoaRequest;
import com.pi.dh.security.permit.CheckSecurity;

@CrossOrigin
@RestController
@RequestMapping("/pessoas")
public class PessoaController {

	@Autowired
	private PessoaService pessoaService;
	
	@Autowired
	private EnderecoService enderecoService;
	
	@PostMapping
	public ResponseEntity<?> salvar(@RequestBody @Valid PessoaRequest pessoaRequest) {
		
		try {
			PessoaDTO pessoaDTO = pessoaService.salvar(pessoaRequest);
			enderecoService.salvar(pessoaRequest.getEndereco());
			return ResponseEntity.status(HttpStatus.CREATED).body(pessoaDTO);
			
		} catch (Exception ex) {
			return ResponseEntity.badRequest().body(ex.getMessage());
		}
	}
	
	@CheckSecurity.Pessoa.PodeConsultar
	@GetMapping
	public List<PessoaDTO> listar() {
		return pessoaService.listar();
	}
	
	@GetMapping("/{id}")
	public PessoaDTO buscarPorId(@PathVariable Long id) {
		return pessoaService.buscarPorId(id);
	}
	
	@DeleteMapping("/{id}")
	public void excluir(@PathVariable Long id) {
		pessoaService.excluir(id);
	}
	
	@PutMapping("/{id}")
	public void atualizar(@RequestBody PessoaRequest pessoa, @PathVariable Long id) {
		pessoaService.atualizar(pessoa, id);
	}
}
