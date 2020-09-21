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

import com.pi.dh.domain.model.Informe;
import com.pi.dh.domain.repository.InformeRepository;

@RestController
@RequestMapping("/informes")
public class InformeController {

	@Autowired
	private InformeRepository informeRepository;
	
	@PostMapping
	public void salvar(@RequestBody Informe informe) {
		informeRepository.save(informe);
	}
	
	@GetMapping
	public List<Informe> listar() {
		return informeRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Informe buscar(@PathVariable Long id) {
		return informeRepository.findById(id).get();
	}
	
	@DeleteMapping("/{id}")
	public void excluir(@PathVariable Long id) {
		informeRepository.deleteById(id);
	}
	
	@PutMapping("/{id}")
	public void atualizar(@RequestBody Informe informe, @PathVariable Long id) {
		Informe inf = informeRepository.findById(id).get();
		inf.setTitulo(informe.getTitulo());
		inf.setDescricao(informe.getDescricao());
		inf.setPrioridade(informe.getPrioridade());
		inf.setDepartamento(informe.getDepartamento());
		inf.setProfessor(informe.getProfessor());
		inf.setDataPublicacao(informe.getDataPublicacao());
		
		informeRepository.save(inf);
	}
}
