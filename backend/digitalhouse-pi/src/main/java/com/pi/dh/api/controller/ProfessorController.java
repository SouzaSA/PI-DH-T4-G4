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

import com.pi.dh.domain.service.ProfessorService;
import com.pi.dh.dto.ProfessorDTO;
import com.pi.dh.request.ProfessorRequest;
import com.pi.dh.security.permit.CheckSecurity;

@RestController
@RequestMapping("/professores")
@CrossOrigin
public class ProfessorController {

	@Autowired
	private ProfessorService professorService;
	
	@PostMapping
	public ResponseEntity<?> salvar(@RequestBody @Valid ProfessorRequest professorRequest) {
		
		try {
			ProfessorDTO professorDTO = professorService.salvar(professorRequest);
			return ResponseEntity.status(HttpStatus.CREATED).body(professorDTO);
			
		} catch (Exception ex) {
			return ResponseEntity.badRequest().body(ex.getMessage());
		}
	}
	
	@CheckSecurity.Professor.PodeConsultar
	@GetMapping
	public List<ProfessorDTO> listar() {
		return professorService.listar();
	}
	
	@GetMapping("/{id}")
	public ProfessorDTO buscarPorId(@PathVariable Long id) {
		return professorService.buscarPorId(id);
	}
	
	@DeleteMapping("/{id}")
	public void excluir(@PathVariable Long id) {
		professorService.excluir(id);
	}
	
	@PutMapping("/{id}")
	public void atualizar(@RequestBody ProfessorRequest professor, @PathVariable Long id) {
		professorService.atualizar(professor, id);
	}
}
