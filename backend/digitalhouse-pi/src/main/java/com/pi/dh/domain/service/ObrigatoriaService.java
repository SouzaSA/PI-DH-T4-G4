package com.pi.dh.domain.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pi.dh.domain.model.Obrigatoria;
import com.pi.dh.domain.repository.ObrigatoriaRepository;

@Service
public class ObrigatoriaService {

	@Autowired
	private ObrigatoriaRepository obrigatoriaRepository;
	
	@Transactional
	public void salvar(Obrigatoria obrigatoria) {
		obrigatoriaRepository.save(obrigatoria);
	}
	
	public List<Obrigatoria> listar() {
		return obrigatoriaRepository.findAll();
	}
	
	public Obrigatoria buscarPorId(Long id) {
		return obrigatoriaRepository.findById(id).get();
	}
	
	@Transactional
	public void excluir(Long id) {
		obrigatoriaRepository.deleteById(id);
	}
	
	@Transactional
	public void atualizar(Obrigatoria obrigatoria, Long id) {
		Obrigatoria obr = obrigatoriaRepository.findById(id).get();
		
		obr.setCurso(obrigatoria.getCurso());
		obr.setDisciplina(obrigatoria.getDisciplina());

		
		obrigatoriaRepository.save(obr);
	}
}
