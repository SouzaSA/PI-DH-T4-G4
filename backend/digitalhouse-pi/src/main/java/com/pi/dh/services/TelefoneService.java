package com.pi.dh.services;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.pi.dh.model.Telefone;
import com.pi.dh.repository.TelefoneRepository;

import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class TelefoneService {

	@Autowired
	private TelefoneRepository telefoneRepository;

	public Telefone find(Long id) throws ObjectNotFoundException {
		Optional<Telefone> obj = telefoneRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Telefone.class.getName()));
	}

	@Transactional
	public Telefone insert(Telefone obj) throws ObjectNotFoundException {
		obj.setTelefoneId(null);
		obj = telefoneRepository.save(obj);
		telefoneRepository.saveAll(Arrays.asList(obj));
		return obj;
	}

	public Telefone update(Telefone obj) throws ObjectNotFoundException {
		find(obj.getTelefoneId());
		telefoneRepository.saveAll(Arrays.asList(obj));
		return telefoneRepository.save(obj);
	}

	public void delete(Long id) throws ObjectNotFoundException {
		find(id);
		try {
			telefoneRepository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw e;
		}
	}

	public List<Telefone> findAll() {
		return telefoneRepository.findAll();
	}

	public Page<Telefone> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return telefoneRepository.findAll(pageRequest);
	}

}
