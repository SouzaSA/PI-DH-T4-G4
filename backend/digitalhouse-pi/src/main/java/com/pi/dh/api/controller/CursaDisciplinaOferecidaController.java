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

import com.pi.dh.domain.model.CursaDisciplinaOferecida;
import com.pi.dh.domain.service.CursaDisciplinaOferecidaService;

@RestController
@RequestMapping("/cursaDisciplinasOferecidas")
public class CursaDisciplinaOferecidaController {

	@Autowired
	private CursaDisciplinaOferecidaService cursaDisciplinaOferecidaService;
	
	@PostMapping
	public void salvar(@RequestBody CursaDisciplinaOferecida cursaDisciplinaOferecida) {
		cursaDisciplinaOferecidaService.salvar(cursaDisciplinaOferecida);
	}
	
	@GetMapping
	public List<CursaDisciplinaOferecida> listar() {
		return cursaDisciplinaOferecidaService.listar();
	}
	
	@GetMapping("/{id}")
	public CursaDisciplinaOferecida buscarPorId(@PathVariable Long id) {
		return cursaDisciplinaOferecidaService.buscarPorId(id);
	}
	
	@DeleteMapping("/{id}")
	public void excluir(@PathVariable Long id) {
		cursaDisciplinaOferecidaService.excluir(id);
	}
	
	@PutMapping("/{id}")
	public void atualizar(@RequestBody CursaDisciplinaOferecida cursaDisciplinaOferecida, @PathVariable Long id) {
		cursaDisciplinaOferecidaService.atualizar(cursaDisciplinaOferecida, id);
	}
}
