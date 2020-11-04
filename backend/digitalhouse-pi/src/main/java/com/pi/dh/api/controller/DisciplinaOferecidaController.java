package com.pi.dh.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pi.dh.domain.model.DisciplinaOferecida;
import com.pi.dh.domain.service.DisciplinaOferecidaService;
import com.pi.dh.dto.DisciplinaOferecidaDTO;

@RestController
@RequestMapping("/disciplinaOferecidas")
@CrossOrigin
public class DisciplinaOferecidaController {

	@Autowired
	private DisciplinaOferecidaService disciplinaOferecidaService;
	
	@PostMapping
	public void salvar(@RequestBody DisciplinaOferecida disciplinaOferecida) {
		disciplinaOferecidaService.salvar(disciplinaOferecida);
	}
	
	@GetMapping
	public List<DisciplinaOferecidaDTO> listar() {
		return disciplinaOferecidaService.listar();
	}
	
	@GetMapping("/{id}")
	public DisciplinaOferecida buscarPorId(@PathVariable Long id) {
		return disciplinaOferecidaService.buscarPorId(id);
	}
	
	@DeleteMapping("/{id}")
	public void excluir(@PathVariable Long id) {
		disciplinaOferecidaService.excluir(id);
	}
	
	@PutMapping("/{id}")
	public void atualizar(@RequestBody DisciplinaOferecida disciplinaOferecida, @PathVariable Long id) {
		disciplinaOferecidaService.atualizar(disciplinaOferecida, id);
	}
}
