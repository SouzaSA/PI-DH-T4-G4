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

import com.pi.dh.domain.service.AlunoService;
import com.pi.dh.dto.AlunoDTO;
import com.pi.dh.request.AlunoRequest;

@RestController
@RequestMapping("/alunos")
@CrossOrigin
public class AlunoController {

	@Autowired
	private AlunoService alunoService;

		
	@PostMapping
	public ResponseEntity<?> salvar(@RequestBody @Valid AlunoRequest alunoRequest) {
		
		try {
			AlunoDTO alunoDTO = alunoService.salvar(alunoRequest);
			return ResponseEntity.status(HttpStatus.CREATED).body(alunoDTO);
			
		} catch (Exception ex) {
			return ResponseEntity.badRequest().body(ex.getMessage());
		}
	}
	
	@GetMapping
	public List<AlunoDTO> listar() {
		return alunoService.listar();
	}
	
	@GetMapping("/{id}")
	public AlunoDTO buscarPorId(@PathVariable Long id) {
		return alunoService.buscarPorId(id);
	}
	
	@DeleteMapping("/{id}")
	public void excluir(@PathVariable Long id) {
		alunoService.excluir(id);
	}
	
	@PutMapping("/{id}")
	public void atualizar(@RequestBody AlunoRequest aluno, @PathVariable Long id) {		
		alunoService.atualizar(aluno, id);
	}
}
