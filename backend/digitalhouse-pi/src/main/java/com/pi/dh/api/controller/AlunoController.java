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

import com.pi.dh.domain.model.Aluno;
import com.pi.dh.domain.service.AlunoService;

@RestController
@RequestMapping("/alunos")
@CrossOrigin
public class AlunoController {

	@Autowired
	private AlunoService alunoService;
	
	@PostMapping
	public void salvar(@RequestBody Aluno aluno) {
		alunoService.salvar(aluno);
	}
	
	@GetMapping
	public List<Aluno> listar() {
		return alunoService.listar();
	}
	
	@GetMapping("/{id}")
	public Aluno buscarPorId(@PathVariable Long id) {
		return alunoService.buscarPorId(id);
	}
	
	@DeleteMapping("/{id}")
	public void excluir(@PathVariable Long id) {
		alunoService.excluir(id);
	}
	
	@PutMapping("/{id}")
	public void atualizar(@RequestBody Aluno aluno, @PathVariable Long id) {		
		alunoService.atualizar(aluno, id);
	}
}
