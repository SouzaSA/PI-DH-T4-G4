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

import com.pi.dh.domain.model.CursaDisciplinaOferecida;
import com.pi.dh.domain.service.CursaDisciplinaOferecidaService;
import com.pi.dh.dto.CursaDisciplinaOferecidaDTO;
import com.pi.dh.request.CursaDisciplinaOferecidaRequest;

@RestController
@RequestMapping("/cursaDisciplinasOferecidas")
@CrossOrigin
public class CursaDisciplinaOferecidaController {

	@Autowired
	private CursaDisciplinaOferecidaService cursaDisciplinaOferecidaService;
	
	@PostMapping
	public void salvar(@RequestBody CursaDisciplinaOferecida cursaDisciplinaOferecida) {
		cursaDisciplinaOferecidaService.salvar(cursaDisciplinaOferecida);
	}
	
	@GetMapping
	public List<CursaDisciplinaOferecidaDTO> listar() {
		return cursaDisciplinaOferecidaService.listar();
	}
	
	@GetMapping("/{id}")
	public CursaDisciplinaOferecidaDTO buscarPorId(@PathVariable Long id) {
		return cursaDisciplinaOferecidaService.buscarPorId(id);
	}
	
	@DeleteMapping("/{id}")
	public void excluir(@PathVariable Long id) {
		cursaDisciplinaOferecidaService.excluir(id);
	}
	
	@PutMapping("/{id}")
	public void atualizar(@RequestBody CursaDisciplinaOferecidaRequest cursaDisciplinaOferecida, @PathVariable Long id) {
		cursaDisciplinaOferecidaService.atualizar(cursaDisciplinaOferecida, id);
	}
}
