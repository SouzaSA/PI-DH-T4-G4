package com.pi.dh.domain.service;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.pi.dh.domain.model.Pessoa;
import com.pi.dh.domain.repository.PessoaRepository;
import com.pi.dh.dto.PessoaDTO;
import com.pi.dh.mapper.PessoaMapper;
import com.pi.dh.request.PessoaRequest;

@Service
public class PessoaService {

	@Autowired
	private PessoaRepository pessoaRepository;
	
	@Autowired
	private PessoaMapper mapper;
	
	public static String geraPassBase64(String nomeSobrenome) {
	    String pass = "";
	    
	    PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	    
	    pass = passwordEncoder.encode(nomeSobrenome);
	    //decode =>>>  String textoDeserializado = new String(Base64.getDecoder().decode(pass));
	    return pass;
	}
		
	@Transactional
	public PessoaDTO salvar(PessoaRequest pessoaRequest) {
		
		Pessoa pessoa = mapper.requestToModel(pessoaRequest);
		
		pessoa.setPessoaId(null);
		pessoa.setDataCadastro(OffsetDateTime.now());
		pessoa.setPassword(geraPassBase64(pessoa.getNome()+pessoa.getSobrenome()));
		pessoa.getTelefones().stream().forEach(telefone -> telefone.setPessoa(pessoa));
		pessoa.setGrupos(pessoa.getGrupos());

		//pessoa.setGrupos(getGrupos(pessoaRequest.getGrupos()));
	    return mapper.modelToDTO( pessoaRepository.save(pessoa) );
	    
	}
	
	public List<PessoaDTO> listar() {
		//return pessoaRepository.findAll();
		return pessoaRepository.findAll()
				.stream()
				.map(pess -> mapper.modelToDTO(pess))
				.collect(Collectors.toList());
	}
	
	public PessoaDTO buscarPorId(Long id) {
		return mapper.modelToDTO(pessoaRepository.findById(id).get());
	}
	
	@Transactional
	public void excluir(Long id) {
		pessoaRepository.deleteById(id);
	}
	
	@Transactional
	public void atualizar(PessoaRequest pessoa, Long id) {
		Pessoa pess = pessoaRepository.findById(id).get();
		
		pess.setSobrenome(pessoa.getSobrenome());
		pess.setNome(pessoa.getNome());
		pess.setEmail(pessoa.getEmail());
		pess.setPassword(pessoa.getPassword());
		pess.setFoto(pessoa.getFoto());
		
		pessoaRepository.save(pess);
	}
}
