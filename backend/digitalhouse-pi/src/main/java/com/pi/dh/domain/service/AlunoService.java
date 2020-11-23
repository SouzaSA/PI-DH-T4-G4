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

import com.pi.dh.domain.model.Aluno;
import com.pi.dh.domain.model.Pessoa;
import com.pi.dh.domain.model.Telefone;
import com.pi.dh.domain.repository.AlunoRepository;
import com.pi.dh.domain.repository.CursoRepository;
import com.pi.dh.domain.repository.GrupoRepository;
import com.pi.dh.domain.repository.PessoaRepository;
import com.pi.dh.domain.repository.TelefoneRepository;
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
	private CursoRepository cursoRepository;
	
	@Autowired
	private TelefoneRepository telefoneRepository;
	
	@Autowired
	private GrupoRepository grupoRepository;
	
	@Autowired
	private AlunoMapper mapper;
	
	public static String geraPassBase64(String nomeSobrenome) {
	    String pass = "";
	    
	    PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	    
	    pass = passwordEncoder.encode(nomeSobrenome);
	    //decode =>>>  String textoDeserializado = new String(Base64.getDecoder().decode(pass));
	    return pass;
	}
	
	@Transactional
	public AlunoDTO salvar(@RequestBody AlunoRequest alunoRequest) {
		
		Aluno aluno = mapper.requestToModel(alunoRequest);
		Pessoa pessoa = aluno.getPessoa();
		List<Telefone> telefones = pessoa.getTelefones();
		//Grupo grupo = grupoRepository.findById(3L).get();
		
		aluno.setAlunoId(null);
		pessoa.setPessoaId(null);
		pessoa.setAluno(null);
		pessoa.getGrupos().clear();
		pessoa.getGrupos().add(grupoRepository.findById(2L).get());
		pessoa.setDataCadastro(OffsetDateTime.now());
		pessoa.setPassword(geraPassBase64(pessoa.getNome()+pessoa.getSobrenome()));
		pessoa.setTelefones(null);
		//pessoa.getGrupos().add(grupo);
		pessoaRepository.save(pessoa);
		
		telefones.forEach(telefone -> {
			telefone.setPessoa(pessoa);
			telefoneRepository.save(telefone);
		});
		
		
		aluno.setCurso(cursoRepository.findById(aluno.getCurso().getCursoId()).get());
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
	
	public AlunoDTO buscarPorPessoaId(Long id) {
		return mapper.modelToDTO(alunoRepository.getAlunoIdByPessoaId(id));
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
