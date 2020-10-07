package com.pi.dh.domain.service;

import java.time.OffsetDateTime;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pi.dh.domain.model.Informe;
import com.pi.dh.domain.repository.InformeRepository;

@Service
public class InformeService {

	@Autowired
	private InformeRepository informeRepository;
		
	@Transactional
	public void salvar(Informe informe) {
		informe.setDataPublicacao(OffsetDateTime.now());
		informeRepository.save(informe);
	}
	
	public List<Informe> listar() {
		return informeRepository.findAll();
	}
	
	public Informe buscarPorId(Long id) {
		return informeRepository.findById(id).get();
	}
	
	@Transactional
	public void excluir(Long id) {
		informeRepository.deleteById(id);
	}
	
	@Transactional
	public void atualizar(Informe informe, Long id) {
		Informe inf = informeRepository.findById(id).get();
		inf.setTitulo(informe.getTitulo());
		inf.setDescricao(informe.getDescricao());
		inf.setDepartamento(informe.getDepartamento());
		inf.setProfessor(informe.getProfessor());
		inf.setDataPublicacao(informe.getDataPublicacao());
		inf.setPrioridade(informe.getPrioridade());
		
		informeRepository.save(inf);
	}

}
