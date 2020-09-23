package com.pi.dh.domain.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pi.dh.domain.model.Nota;
import com.pi.dh.domain.repository.NotaRepository;

@Service
public class NotaService {
	
	@Autowired
	private NotaRepository notaRepository;
	
	@Transactional
	public void salvar(Nota nota) {
		notaRepository.save(nota);
	}
	
	public List<Nota> listar() {
		return notaRepository.findAll();
	}
	
	public Nota buscarPorId(Long id) {
		return notaRepository.findById(id).get();
	}
	
	@Transactional
	public void excluir(Long id) {
		notaRepository.deleteById(id);
	}
	
	@Transactional
	public void atualizar(Nota nota, Long id) {
		Nota no = notaRepository.findById(id).get();
		
		no.setTitulo(nota.getTitulo());
		no.setValor(nota.getValor());
		no.setDisciplinaCursadaAluno(nota.getDisciplinaCursadaAluno());

		
		notaRepository.save(no);
	}
}
