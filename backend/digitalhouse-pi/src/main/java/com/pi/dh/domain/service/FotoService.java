package com.pi.dh.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.pi.dh.domain.model.Foto;
import com.pi.dh.domain.model.Pessoa;
import com.pi.dh.domain.repository.FotoRepository;
import com.pi.dh.domain.repository.PessoaRepository;
import com.pi.dh.dto.FotoDTO;
import com.pi.dh.mapper.FotoMapper;
import com.pi.dh.request.FotoRequest;

@Service
public class FotoService {

	@Autowired
	private FotoRepository repository;
	
	@Autowired
	private FotoMapper mapper;
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	public FotoDTO salvar(FotoRequest fotoRequest, Long id) {
		
		Foto foto = mapper.requestToModel(fotoRequest);
		
		Pessoa pessoa = pessoaRepository.findById(id).get();
	
		MultipartFile arquivo = fotoRequest.getFoto();
		foto.setPessoa(pessoa);
		foto.setContentType(arquivo.getContentType());
		foto.setTamanho(arquivo.getSize());
		foto.setNomeArquivo(arquivo.getOriginalFilename());
	    
	    return mapper.modelToDTO( repository.save(foto) );	
	}
}
