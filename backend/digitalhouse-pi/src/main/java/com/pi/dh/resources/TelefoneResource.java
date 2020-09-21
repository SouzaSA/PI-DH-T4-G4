package com.pi.dh.resources;

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

import com.pi.dh.model.Telefone;
import com.pi.dh.services.TelefoneService;

import javassist.tools.rmi.ObjectNotFoundException;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/telefones")
public class TelefoneResource {
	
	@Autowired
	private TelefoneService service;
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<Telefone>> findAll() {
		List<Telefone> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@RequestMapping(value="/page", method=RequestMethod.GET)
	public ResponseEntity<Page<Telefone>> findPage(
			@RequestParam(value="page", defaultValue="0") Integer page, 
			@RequestParam(value="linesPerPage", defaultValue="24") Integer linesPerPage, 
			@RequestParam(value="orderBy", defaultValue="nome") String orderBy, 
			@RequestParam(value="direction", defaultValue="ASC") String direction) {
		Page<Telefone> list = service.findPage(page, linesPerPage, orderBy, direction);
		return ResponseEntity.ok().body(list);
	}	
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Telefone> find(@PathVariable Long id) throws ObjectNotFoundException {
		Telefone obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}	

	@RequestMapping(method=RequestMethod.POST)
	public void insert(@RequestBody Telefone telefone) throws ObjectNotFoundException {
		service.insert(telefone);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Void> update(@Valid @RequestBody Telefone obj, @PathVariable Long id) throws ObjectNotFoundException {
		obj.setTelefoneId(id);
		obj = service.update(obj);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Long id) throws ObjectNotFoundException {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

}
