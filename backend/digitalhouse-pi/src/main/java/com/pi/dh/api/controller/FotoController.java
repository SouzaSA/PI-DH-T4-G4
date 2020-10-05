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

import com.pi.dh.domain.model.Foto;
import com.pi.dh.domain.service.FotoService;

@RestController
@RequestMapping("/fotos")
@CrossOrigin
public class FotoController {

	@Autowired
	private FotoService fotoService;
	
	@PostMapping
	public void salvar(@RequestBody Foto foto) {
		fotoService.salvar(foto);
	}
	
	@GetMapping
	public List<Foto> listar() {
		return fotoService.listar();
	}
	
	@GetMapping("/{id}")
	public Foto buscarPorId(@PathVariable Long id) {
		return fotoService.buscarPorId(id);
	}
	
	@DeleteMapping("/{id}")
	public void excluir(@PathVariable Long id) {
		fotoService.excluir(id);
	}
	
	@PutMapping("/{id}")
	public void atualizar(@RequestBody Foto foto, @PathVariable Long id) {
		fotoService.atualizar(foto, id);
	}
}
