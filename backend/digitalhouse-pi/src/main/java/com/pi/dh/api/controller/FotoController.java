package com.pi.dh.api.controller;

import java.nio.file.Path;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pi.dh.domain.service.FotoService;
import com.pi.dh.dto.FotoDTO;
import com.pi.dh.request.FotoRequest;

@CrossOrigin
@RestController
@RequestMapping("/fotos")
public class FotoController {

	@Autowired
	private FotoService service;
	
	@PostMapping("/{id}")
	public FotoDTO salvarFoto(@Valid FotoRequest foto, @PathVariable Long id) {
		
		String nomeArquivo = UUID.randomUUID().toString() 
				+ "_" + foto.getFoto().getOriginalFilename();
		
		Path arquivoFoto = Path.of("/home/santiago/Pictures/DevTestPics/", nomeArquivo);
		
		try {
			foto.getFoto().transferTo(arquivoFoto);
			
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
		return service.salvar(foto, id);
	}
}
