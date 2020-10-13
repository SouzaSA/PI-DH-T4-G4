package com.pi.dh.domain.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.pi.dh.domain.model.Curso;
import com.pi.dh.domain.repository.CursoRepository;
import com.pi.dh.dto.CursoDTO;
import com.pi.dh.mapper.CursoMapper;
import com.pi.dh.request.CursoRequest;

@Service
public class CursoService {
	
	@Autowired
	private CursoRepository cursoRepository;
	
	@Autowired
	private CursoMapper mapper;
	
	@Transactional
	public CursoDTO salvar(@RequestBody CursoRequest cursoRequest) {
		
		Curso curso = mapper.requestToModel(cursoRequest);
		curso.setCursoId(null);
		
	    return mapper.modelToDTO( cursoRepository.save(curso) );
	}
	
	public List<Curso> listar() {
		return cursoRepository.findAll();
	}
	
	public Curso buscarPorId(Long id) {
		return cursoRepository.findById(id).get();
	}
	
	@Transactional
	public void excluir(Long id) {
		cursoRepository.deleteById(id);
	}
	
	@Transactional
	public void atualizar(Curso curso, Long id) {
		Curso cur = cursoRepository.findById(id).get();
		
		cur.setNome(curso.getNome());
		cur.setProfessor(curso.getProfessor());

		
		cursoRepository.save(cur);
	}
}
