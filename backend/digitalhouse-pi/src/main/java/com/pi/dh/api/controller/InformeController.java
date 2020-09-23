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
import com.pi.dh.domain.service.InformeService;

@RestController
@RequestMapping("/informes")
public class InformeController {

	@Autowired
	private InformeService informeService;
	
	@PostMapping
	public void salvar(@RequestBody Informe informe) {
		informeService.salvar(informe);
	}
	
	@GetMapping
	public List<Informe> listar() {
		return informeService.listar();
	}
	
	@GetMapping("/{id}")
	public Informe buscarPorId(@PathVariable Long id) {
		return informeService.buscarPorId(id);
	}
	
	@DeleteMapping("/{id}")
	public void excluir(@PathVariable Long id) {
		informeService.excluir(id);
	}
	
	@PutMapping("/{id}")
	public void atualizar(@RequestBody Informe informe, @PathVariable Long id) {
		informeService.atualizar(informe, id);
	}
}
