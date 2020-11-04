package com.pi.dh.domain.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.pi.dh.domain.model.Aluno;
import com.pi.dh.domain.repository.AlunoRepository;
import com.pi.dh.domain.repository.CursoRepository;
import com.pi.dh.domain.repository.EnderecoRepository;
import com.pi.dh.domain.repository.PessoaRepository;
import com.pi.dh.dto.AlunoDTO;
import com.pi.dh.mapper.AlunoMapper;
import com.pi.dh.request.AlunoRequest;

@Service
public class AlunoService {

	@Autowired
	private AlunoRepository alunoRepository;
	
	@Autowired 
	private PessoaRepository pessoaRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@Autowired
	private CursoRepository cursoRepository;
	
	@Autowired
	private AlunoMapper mapper;
	
	@Transactional
	public AlunoDTO salvar(@RequestBody AlunoRequest alunoRequest) {
		
		Aluno aluno = mapper.requestToModel(alunoRequest);
		
		cursoRepository.save(aluno.getCurso());
		enderecoRepository.save(aluno.getPessoa().getEndereco());
		pessoaRepository.save(aluno.getPessoa());
		
		aluno.setAlunoId(null);	
	    return mapper.modelToDTO( alunoRepository.save(aluno) );
	}
	
	public List<AlunoDTO> listar() {
		//return alunoRepository.findAll();
		return alunoRepository.findAll()
				.stream()
				.map(alu -> mapper.modelToDTO(alu))
				.collect(Collectors.toList());
	}
	
	public AlunoDTO buscarPorId(Long id) {
		return mapper.modelToDTO(alunoRepository.findById(id).get());
	}
	
	@Transactional
	public void excluir(Long id) {
		alunoRepository.deleteById(id);
	}
	
	@Transactional
	public void atualizar(AlunoRequest aluno, Long id) {
		Aluno al = alunoRepository.findById(id).get();
		
		al.setPessoa(mapper.requestToModel(aluno).getPessoa());
		al.setCurso(mapper.requestToModel(aluno).getCurso());
		
		alunoRepository.save(al);
	}
}
