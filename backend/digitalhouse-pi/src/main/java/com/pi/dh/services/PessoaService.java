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

import com.pi.dh.DTO.newPessoaDTO;
import com.pi.dh.model.Pessoa;
import com.pi.dh.repository.PessoaRepository;

import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class PessoaService {

	@Autowired
	private PessoaRepository pessoaRepository;
	

	public Pessoa find(Long id) throws ObjectNotFoundException {
		Optional<Pessoa> obj = pessoaRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Pessoa.class.getName()));
	}

	@Transactional
	public Pessoa insert(Pessoa obj) throws ObjectNotFoundException {
		obj.setPessoaId(null);
		obj = pessoaRepository.save(obj);
		pessoaRepository.saveAll(Arrays.asList(obj));
		return obj;
	}

	public Pessoa update(Pessoa obj) throws ObjectNotFoundException {
		find(obj.getPessoaId());
		pessoaRepository.saveAll(Arrays.asList(obj));
		return pessoaRepository.save(obj);
	}

	public void delete(Long id) throws ObjectNotFoundException {
		find(id);
		try {
			pessoaRepository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw e;
		}
	}

	public List<Pessoa> findAll() {
		return pessoaRepository.findAll();
	}

	public Page<Pessoa> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return pessoaRepository.findAll(pageRequest);
	}

	public Pessoa fromDTO(newPessoaDTO objDto) throws ObjectNotFoundException {

		Pessoa pessoa = new Pessoa(null, objDto.getCep(), objDto.getRua(), objDto.getNumero(), objDto.getBairro(),
				objDto.getCidade(), objDto.getEstado(), objDto.getComplemento(), objDto.getSobrenome(),
				objDto.getNome(), objDto.getEmail(), objDto.getPassword(), objDto.getFoto(), objDto.getTelefone1(), objDto.getTelefone2());
	
				return pessoa;

	}
}
