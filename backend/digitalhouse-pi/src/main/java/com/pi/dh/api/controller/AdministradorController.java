package com.pi.dh.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pi.dh.domain.service.AdministradorService;
import com.pi.dh.dto.AdministradorDTO;
import com.pi.dh.request.AdministradorRequest;
import com.pi.dh.security.permit.CheckSecurity;

@CrossOrigin
@RestController
@RequestMapping("/administradores")
public class AdministradorController {

	@Autowired
	private AdministradorService administradorService;
	
	
	@PostMapping
	public ResponseEntity<?> salvar(@RequestBody @Valid AdministradorRequest administradorRequest) {
		
		try {
			AdministradorDTO administradorDTO = administradorService.salvar(administradorRequest);
			return ResponseEntity.status(HttpStatus.CREATED).body(administradorDTO);
			
		} catch (Exception ex) {
			return ResponseEntity.badRequest().body(ex.getMessage());
		}
	}
	
	@CheckSecurity.Administrador.PodeConsultar
	@GetMapping
	public List<AdministradorDTO> listar() {
		return administradorService.listar();
	}
	
	@GetMapping("/{id}")
	public AdministradorDTO buscarPorId(@PathVariable Long id) {
		return administradorService.buscarPorId(id);
	}
	
	@GetMapping("/pessoa/{id}")
	public AdministradorDTO buscarPorPessoaId(@PathVariable Long id) {
		return administradorService.buscarPorPessoaId(id);
	}
	
	@DeleteMapping("/{id}")
	public void excluir(@PathVariable Long id) {
		administradorService.excluir(id);
	}
	
	@PutMapping("/{id}")
	public void atualizar(@RequestBody AdministradorRequest administrador, @PathVariable Long id) {
		administradorService.atualizar(administrador, id);
	}
}
