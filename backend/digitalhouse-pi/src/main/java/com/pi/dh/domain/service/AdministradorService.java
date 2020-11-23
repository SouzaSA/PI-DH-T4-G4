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

import com.pi.dh.domain.model.Administrador;
import com.pi.dh.domain.model.Pessoa;
import com.pi.dh.domain.model.Telefone;
import com.pi.dh.domain.repository.AdministradorRepository;
import com.pi.dh.domain.repository.GrupoRepository;
import com.pi.dh.domain.repository.PessoaRepository;
import com.pi.dh.domain.repository.TelefoneRepository;
import com.pi.dh.dto.AdministradorDTO;
import com.pi.dh.mapper.AdministradorMapper;
import com.pi.dh.request.AdministradorRequest;

@Service
public class AdministradorService {

	@Autowired
	private AdministradorRepository administradorRepository;
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	@Autowired
	private TelefoneRepository telefoneRepository;
	
	@Autowired
	private GrupoRepository grupoRepository;

	@Autowired
	private AdministradorMapper mapper;
	
	public static String geraPassBase64(String nomeSobrenome) {
	    String pass = "";
	    
	    PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	    
	    pass = passwordEncoder.encode(nomeSobrenome);
	    //decode =>>>  String textoDeserializado = new String(Base64.getDecoder().decode(pass));
	    return pass;
	}
	
	@Transactional
	public AdministradorDTO salvar(@RequestBody AdministradorRequest administradorRequest) {
	
		Administrador admin = mapper.requestToModel(administradorRequest);
		Pessoa pessoa = admin.getPessoa();
		List<Telefone> telefones = pessoa.getTelefones();
	
		admin.setAdministradorId(null);
		pessoa.setPessoaId(null);
		pessoa.setAdministrador(null);
		pessoa.getGrupos().clear();
		pessoa.getGrupos().add(grupoRepository.findById(3L).get());
		pessoa.setDataCadastro(OffsetDateTime.now());
		pessoa.setPassword(geraPassBase64(pessoa.getNome()+pessoa.getSobrenome()));
		pessoa.setTelefones(null);
		pessoaRepository.save(pessoa);
		
		telefones.forEach(telefone -> {
			telefone.setPessoa(pessoa);
			telefoneRepository.save(telefone);
		});
		
		//grupo.getPessoa().add(pessoa);
		//grupoRepository.save(grupo);

		System.out.println(admin.getPessoa());
		
		//admin.setPessoa(pessoa);
		//admin.setAdministradorId(null);
		
	    return mapper.modelToDTO( administradorRepository.save(admin) );
	}
	
	public List<AdministradorDTO> listar() {
		//return administradorRepository.findAll();
		return administradorRepository.findAll()
				.stream()
				.map(pess -> mapper.modelToDTO(pess))
				.collect(Collectors.toList());
	}
	
	public AdministradorDTO buscarPorId(Long id) {
		return mapper.modelToDTO(administradorRepository.findById(id).get());
	}
	
	public AdministradorDTO buscarPorPessoaId(Long id) {
		return mapper.modelToDTO(administradorRepository.getAdministradorIdByPessoaId(id));
	}
	
	@Transactional
	public void excluir(Long id) {
		administradorRepository.deleteById(id);
	}
	
	@Transactional
	public void atualizar(AdministradorRequest administrador, Long id) {
		Administrador adm = administradorRepository.findById(id).get();
		
		adm.setPessoa(mapper.requestToModel(administrador).getPessoa());
		
		administradorRepository.save(adm);
	}
}
