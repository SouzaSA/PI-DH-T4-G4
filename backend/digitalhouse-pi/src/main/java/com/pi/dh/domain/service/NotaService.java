package com.pi.dh.domain.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.pi.dh.domain.model.Nota;
import com.pi.dh.domain.repository.NotaRepository;
import com.pi.dh.dto.NotaDTO;
import com.pi.dh.mapper.NotaMapper;
import com.pi.dh.request.NotaRequest;

@Service
public class NotaService {
	
	@Autowired
	private NotaRepository notaRepository;
	
	@Autowired
	private NotaMapper mapper;
	
	@Transactional
	public NotaDTO salvar(@RequestBody NotaRequest notaRequest) {
		
		Nota nota = mapper.requestToModel(notaRequest);
		nota.setNotaId(null);
		
	    return mapper.modelToDTO( notaRepository.save(nota) );
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
