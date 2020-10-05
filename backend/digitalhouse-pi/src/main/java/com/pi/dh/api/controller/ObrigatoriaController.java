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

import com.pi.dh.domain.model.Obrigatoria;
import com.pi.dh.domain.service.ObrigatoriaService;

@RestController
@RequestMapping("/obrigatorias")
@CrossOrigin
public class ObrigatoriaController {

	@Autowired
	private ObrigatoriaService obrigatoriaService;
	
	@PostMapping
	public void salvar(@RequestBody Obrigatoria obrigatoria) {
		obrigatoriaService.salvar(obrigatoria);
	}
	
	@GetMapping
	public List<Obrigatoria> listar() {
		return obrigatoriaService.listar();
	}
	
	@GetMapping("/{id}")
	public Obrigatoria buscarPorId(@PathVariable Long id) {
		return obrigatoriaService.buscarPorId(id);
	}
	
	@DeleteMapping("/{id}")
	public void excluir(@PathVariable Long id) {
		obrigatoriaService.excluir(id);
	}
	
	@PutMapping("/{id}")
	public void atualizar(@RequestBody Obrigatoria obrigatoria, @PathVariable Long id) {
		obrigatoriaService.atualizar(obrigatoria, id);
	}
}
