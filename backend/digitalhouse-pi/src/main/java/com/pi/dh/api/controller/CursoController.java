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

import com.pi.dh.domain.model.Curso;
import com.pi.dh.domain.service.CursoService;
import com.pi.dh.dto.CursoDTO;
import com.pi.dh.request.CursoRequest;

@RestController
@RequestMapping("/cursos")
@CrossOrigin
public class CursoController {

	@Autowired
	private CursoService cursoService;
	
	@PostMapping
	public void salvar(@RequestBody CursoRequest cursoRequest) {
		cursoService.salvar(cursoRequest);
	}
	
	@GetMapping
	public List<CursoDTO> listar() {
		return cursoService.listar();
	}
	
	@GetMapping("/{id}")
	public Curso buscarPorId(@PathVariable Long id) {
		return cursoService.buscarPorId(id);
	}
	
	@DeleteMapping("/{id}")
	public void excluir(@PathVariable Long id) {
		cursoService.excluir(id);
	}
	
	@PutMapping("/{id}")
	public void atualizar(@RequestBody Curso curso, @PathVariable Long id) {
		cursoService.atualizar(curso, id);
	}
}
