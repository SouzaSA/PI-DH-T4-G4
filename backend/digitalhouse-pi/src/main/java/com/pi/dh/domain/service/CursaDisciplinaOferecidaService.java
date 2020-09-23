package com.pi.dh.domain.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pi.dh.domain.model.CursaDisciplinaOferecida;
import com.pi.dh.domain.repository.CursaDisciplinaOferecidaRepository;

@Service
public class CursaDisciplinaOferecidaService {

	@Autowired
	private CursaDisciplinaOferecidaRepository cursaDisciplinaOferecidaRepository;
	
	@Transactional
	public void salvar(CursaDisciplinaOferecida cursaDisciplinaOferecida) {
		cursaDisciplinaOferecidaRepository.save(cursaDisciplinaOferecida);
	}
	
	public List<CursaDisciplinaOferecida> listar() {
		return cursaDisciplinaOferecidaRepository.findAll();
	}
	
	public CursaDisciplinaOferecida buscarPorId(Long id) {
		return cursaDisciplinaOferecidaRepository.findById(id).get();
	}
	
	@Transactional
	public void excluir(Long id) {
		cursaDisciplinaOferecidaRepository.deleteById(id);
	}
	
	@Transactional
	public void atualizar(CursaDisciplinaOferecida cursaDisciplinaOferecida, Long id) {
		CursaDisciplinaOferecida cdo = cursaDisciplinaOferecidaRepository.findById(id).get();
		
		cdo.setDataInscricao(cursaDisciplinaOferecida.getDataInscricao());
		cdo.setData_deferimento(cursaDisciplinaOferecida.getData_deferimento());
		cdo.setAluno(cursaDisciplinaOferecida.getAluno());
		cdo.setDisciplinaOferecida(cursaDisciplinaOferecida.getDisciplinaOferecida());

		
		cursaDisciplinaOferecidaRepository.save(cdo);
	}
}
