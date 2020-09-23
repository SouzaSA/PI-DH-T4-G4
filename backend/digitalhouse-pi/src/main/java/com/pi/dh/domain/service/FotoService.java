package com.pi.dh.domain.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pi.dh.domain.model.Foto;
import com.pi.dh.domain.repository.FotoRepository;

@Service
public class FotoService {

	@Autowired
	private FotoRepository fotoRepository;
	
	@Transactional
	public void salvar(Foto foto) {
		fotoRepository.save(foto);
	}
	
	public List<Foto> listar() {
		return fotoRepository.findAll();
	}
	
	public Foto buscarPorId(Long id) {
		return fotoRepository.findById(id).get();
	}
	
	@Transactional
	public void excluir(Long id) {
		fotoRepository.deleteById(id);
	}
	
	@Transactional
	public void atualizar(Foto foto, Long id) {
		Foto fo = fotoRepository.findById(id).get();
		
		fo.setEndereco(foto.getEndereco());
		fo.setInforme(foto.getInforme());

		
		fotoRepository.save(fo);
	}
}
