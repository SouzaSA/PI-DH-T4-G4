package com.pi.dh.domain.service;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.pi.dh.domain.model.Pessoa;
import com.pi.dh.domain.model.Professor;
import com.pi.dh.domain.model.Telefone;
import com.pi.dh.domain.model.enums.Departamentos;
import com.pi.dh.domain.repository.GrupoRepository;
import com.pi.dh.domain.repository.PessoaRepository;
import com.pi.dh.domain.repository.ProfessorRepository;
import com.pi.dh.domain.repository.TelefoneRepository;
import com.pi.dh.dto.ProfessorDTO;
import com.pi.dh.mapper.ProfessorMapper;
import com.pi.dh.request.ProfessorRequest;

@Service
public class ProfessorService {

	@Autowired
	private ProfessorRepository professorRepository;
		
	@Autowired 
	private PessoaRepository pessoaRepository;
	
	@Autowired
	private TelefoneRepository telefoneRepository;
	
	@Autowired
	private GrupoRepository grupoRepository;
	
	@Autowired
	private ProfessorMapper mapper;
	
	public static String geraPassBase64(String nomeSobrenome) {
	    String pass = "";
	    
	    PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	    
	    pass = passwordEncoder.encode(nomeSobrenome);
	    //decode =>>>  String textoDeserializado = new String(Base64.getDecoder().decode(pass));
	    return pass;
	}
	
	@Transactional
	public ProfessorDTO salvar(@RequestBody ProfessorRequest professorRequest) {
		
		Professor professor = mapper.requestToModel(professorRequest);
		Pessoa pessoa = professor.getPessoa();
		List<Telefone> telefones = pessoa.getTelefones();
		//Grupo grupo = grupoRepository.findById(3L).get();
	
		professor.setProfessorId(null);
		pessoa.setPessoaId(null);
		pessoa.setProfessor(null);
		pessoa.getGrupos().clear();
		pessoa.getGrupos().add(grupoRepository.findById(1L).get());
		professor.setDepartamento(Departamentos.toEnum(professorRequest.getDepartamento()));
		pessoa.setDataCadastro(OffsetDateTime.now());
		pessoa.setPassword(geraPassBase64(pessoa.getNome()+pessoa.getSobrenome()));
		pessoa.setTelefones(null);
		//pessoa.getGrupos().add(grupo);
		pessoaRepository.save(pessoa);
		
		telefones.forEach(telefone -> {
			telefone.setPessoa(pessoa);
			telefoneRepository.save(telefone);
		});

		pessoaRepository.save(pessoa);
		
	    return mapper.modelToDTO( professorRepository.save(professor) );
	}
	
	public List<ProfessorDTO> listar() {
		//return professorRepository.findAll();
		return professorRepository.findAll()
				.stream()
				.map(prof -> mapper.modelToDTO(prof))
				.collect(Collectors.toList());
	}
	
	public ProfessorDTO buscarPorId(Long id) {
		return mapper.modelToDTO(professorRepository.findById(id).get());
	}
	
	public ProfessorDTO buscarPorPessoaId(Long id) {
		return mapper.modelToDTO(professorRepository.getProfessorIdByPessoaId(id));
	}
	
	@Transactional
	public void excluir(Long id) {
		professorRepository.deleteById(id);
	}
	
	@Transactional
	public void atualizar(ProfessorRequest professor, Long id) {
		Professor prof = professorRepository.findById(id).get();
		
		prof.setPessoa(mapper.requestToModel(professor).getPessoa());
		prof.setDepartamento(mapper.requestToModel(professor).getDepartamento());
		
		professorRepository.save(prof);
	}
}
