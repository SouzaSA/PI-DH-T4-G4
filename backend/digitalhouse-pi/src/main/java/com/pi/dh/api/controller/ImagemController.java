package com.pi.dh.api.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pi.dh.domain.service.ImagemService;
import com.pi.dh.dto.ImagemDTO;
import com.pi.dh.request.ImagemRequest;

@CrossOrigin
@RestController
@RequestMapping("/imagem")
public class ImagemController {
	@Autowired
	private ImagemService service;
	
	@PostMapping
	public ImagemDTO salvarFoto(@Valid ImagemRequest imagem) {
		
		return service.salvar(imagem);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<ImagemDTO> excluir(@PathVariable Long id) {
		try {
			service.excluir(id);	
			return ResponseEntity.noContent().build();
			
		} catch (Exception e) {
			return ResponseEntity.notFound().build();
		}
	}
}