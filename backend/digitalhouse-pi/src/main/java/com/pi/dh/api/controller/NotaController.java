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

import com.pi.dh.domain.model.Nota;
import com.pi.dh.domain.repository.NotaRepository;

@RestController
@RequestMapping("/notas")
public class NotaController {

	@Autowired
	private NotaRepository notaRepository;
	
	@PostMapping
	public void salvar(@RequestBody Nota nota) {
		notaRepository.save(nota);
	}
	
	@GetMapping
	public List<Nota> listar() {
		return notaRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Nota buscar(@PathVariable Long id) {
		return notaRepository.findById(id).get();
	}
	
	@DeleteMapping("/{id}")
	public void excluir(@PathVariable Long id) {
		notaRepository.deleteById(id);
	}
	
	@PutMapping("/{id}")
	public void atualizar(@RequestBody Nota nota, @PathVariable Long id) {
		Nota no = notaRepository.findById(id).get();
		
		no.setTitulo(nota.getTitulo());
		no.setValor(nota.getValor());
		no.setDisciplinaCursadaAluno(nota.getDisciplinaCursadaAluno());

		
		notaRepository.save(no);
	}
}
