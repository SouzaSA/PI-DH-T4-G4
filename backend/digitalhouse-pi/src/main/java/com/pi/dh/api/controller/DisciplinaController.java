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

import com.pi.dh.domain.model.Disciplina;
import com.pi.dh.domain.service.DisciplinaService;
import com.pi.dh.dto.DisciplinaDTO;
import com.pi.dh.request.DisciplinaRequest;

@RestController
@RequestMapping("/disciplinas")
@CrossOrigin
public class DisciplinaController {

	@Autowired
	private DisciplinaService disciplinaService;
	
	@PostMapping
	public ResponseEntity<?> salvar(@RequestBody @Valid DisciplinaRequest disciplinaRequest) {
		
		try {
			DisciplinaDTO disciplinaDTO = disciplinaService.salvar(disciplinaRequest);
			return ResponseEntity.status(HttpStatus.CREATED).body(disciplinaDTO);
			
		} catch (Exception ex) {
			return ResponseEntity.badRequest().body(ex.getMessage());
		}
	}
	
	@GetMapping
	public List<Disciplina> listar() {
		return disciplinaService.listar();
	}
	
	@GetMapping("/{id}")
	public Disciplina buscarPorId(@PathVariable Long id) {
		return disciplinaService.buscarPorId(id);
	}
	
	@DeleteMapping("/{id}")
	public void excluir(@PathVariable Long id) {
		disciplinaService.excluir(id);
	}
	
	@PutMapping("/{id}")
	public void atualizar(@RequestBody Disciplina disciplina, @PathVariable Long id) {
		disciplinaService.atualizar(disciplina, id);
	}
}
