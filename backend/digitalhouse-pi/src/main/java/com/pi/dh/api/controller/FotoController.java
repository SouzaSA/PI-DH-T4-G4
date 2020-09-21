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

import com.pi.dh.domain.model.Foto;
import com.pi.dh.domain.repository.FotoRepository;

@RestController
@RequestMapping("/fotos")
public class FotoController {

	@Autowired
	private FotoRepository fotoRepository;
	
	@PostMapping
	public void salvar(@RequestBody Foto foto) {
		fotoRepository.save(foto);
	}
	
	@GetMapping
	public List<Foto> listar() {
		return fotoRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Foto buscar(@PathVariable Long id) {
		return fotoRepository.findById(id).get();
	}
	
	@DeleteMapping("/{id}")
	public void excluir(@PathVariable Long id) {
		fotoRepository.deleteById(id);
	}
	
	@PutMapping("/{id}")
	public void atualizar(@RequestBody Foto foto, @PathVariable Long id) {
		Foto fo = fotoRepository.findById(id).get();
		
		fo.setEndereco(foto.getEndereco());
		fo.setInforme(foto.getInforme());

		
		fotoRepository.save(fo);
	}
}
