package com.pi.dh.api.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.pi.dh.domain.model.Informe;
import com.pi.dh.domain.model.enums.Departamentos;
import com.pi.dh.domain.service.InformeService;
import com.pi.dh.dto.InformeDTO;

@RestController
@RequestMapping("/informes")
@CrossOrigin
public class InformeController {

	@Autowired
	private InformeService informeService;
	
	@PostMapping
	public void salvar(@RequestBody Informe informe) {
		informeService.salvar(informe);
	}
	
	@GetMapping
	public ResponseEntity<List<InformeDTO>> listar() {
		List<Informe> list = informeService.listar();
		List<InformeDTO> listDto = list.stream().map(obj -> new InformeDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
	
	@GetMapping("/departamento/{departamento}")
	public ResponseEntity<List<InformeDTO>> listarPorDepartamento(@PathVariable String departamento) {
		//System.out.println(Enum.valueOf(Departamentos.class, departamento));
		try {
			Departamentos dpto = Enum.valueOf(Departamentos.class, departamento);
			return ResponseEntity.ok().body(informeService.listarPorDepartamento(dpto));
			
		} catch (Exception ex) {
			 System.out.println("Departamento Inválido");
		}
		return null;
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
