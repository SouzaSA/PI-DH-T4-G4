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

import com.pi.dh.domain.model.Aluno;
import com.pi.dh.domain.repository.AlunoRepository;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

	@Autowired
	private AlunoRepository alunoRepository;
	
	@PostMapping
	public void salvar(@RequestBody Aluno aluno) {
		alunoRepository.save(aluno);
	}
	
	@GetMapping
	public List<Aluno> listar() {
		return alunoRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Aluno buscar(@PathVariable Long id) {
		return alunoRepository.findById(id).get();
	}
	
	@DeleteMapping("/{id}")
	public void excluir(@PathVariable Long id) {
		alunoRepository.deleteById(id);
	}
	
	@PutMapping("/{id}")
	public void atualizar(@RequestBody Aluno aluno, @PathVariable Long id) {
		Aluno al = alunoRepository.findById(id).get();
		
		al.setPessoa(aluno.getPessoa());
		al.setCurso(aluno.getCurso());
		
		alunoRepository.save(al);
	}
}
