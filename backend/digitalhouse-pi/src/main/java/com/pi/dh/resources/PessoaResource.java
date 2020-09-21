package com.pi.dh.resources;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.pi.dh.DTO.newPessoaDTO;
import com.pi.dh.model.Pessoa;
import com.pi.dh.model.Telefone;
import com.pi.dh.services.PessoaService;
import com.pi.dh.services.TelefoneService;

import javassist.tools.rmi.ObjectNotFoundException;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/pessoas")
public class PessoaResource {
	
	@Autowired
	private PessoaService service;
	
	@Autowired
	private TelefoneService telefoneService;
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<Pessoa>> findAll() {
		List<Pessoa> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@RequestMapping(value="/page", method=RequestMethod.GET)
	public ResponseEntity<Page<Pessoa>> findPage(
			@RequestParam(value="page", defaultValue="0") Integer page, 
			@RequestParam(value="linesPerPage", defaultValue="24") Integer linesPerPage, 
			@RequestParam(value="orderBy", defaultValue="nome") String orderBy, 
			@RequestParam(value="direction", defaultValue="ASC") String direction) {
		Page<Pessoa> list = service.findPage(page, linesPerPage, orderBy, direction);
		return ResponseEntity.ok().body(list);
	}	
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Pessoa> find(@PathVariable Long id) throws ObjectNotFoundException {
		Pessoa obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}	

	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody newPessoaDTO objDto) throws ObjectNotFoundException {
		Pessoa obj = service.fromDTO(objDto);
		obj = service.insert(obj);
		Telefone telefone = new Telefone(null, objDto.getTelefone1());
		telefone = telefoneService.insert(telefone);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getPessoaId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Void> update(@Valid @RequestBody Pessoa obj, @PathVariable Long id) throws ObjectNotFoundException {
		obj.setPessoaId(id);
		obj = service.update(obj);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Long id) throws ObjectNotFoundException {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
