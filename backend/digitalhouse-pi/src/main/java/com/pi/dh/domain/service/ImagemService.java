package com.pi.dh.domain.service;

import java.net.URL;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.pi.dh.domain.model.Imagem;
import com.pi.dh.domain.repository.ImagemRepository;
import com.pi.dh.dto.ImagemDTO;
import com.pi.dh.exceptions.ImagemNaoEncontradaException;
import com.pi.dh.mapper.ImagemMapper;
import com.pi.dh.request.ImagemRequest;

@Service
public class ImagemService {
	
	@Autowired
	private ImagemRepository repository;
	
	@Autowired
	private ImagemMapper mapper;
	
	@Autowired
	private S3FotoStorageService s3FotoStorageService;

	@Transactional
	public ImagemDTO salvar(ImagemRequest imagemRequest) {

		MultipartFile arquivo = imagemRequest.getImagem();

		String nomeArquivo = UUID.randomUUID().toString() + "_" + arquivo.getOriginalFilename();

		Imagem imagem = mapper.requestToModel(imagemRequest);

		imagem.setNomeArquivo(arquivo.getOriginalFilename());
		imagem.setNomeArquivoCompleto(nomeArquivo);
		imagem.setContentType(arquivo.getContentType());
		imagem.setTamanho(arquivo.getSize());

		URL url = s3FotoStorageService.armazenar(arquivo, nomeArquivo);
		imagem.setUrl(url);

		return mapper.modelToDTO(repository.save(imagem));
	}

	@Transactional
	public void excluir(Long id) {

		Imagem imagem = repository.findById(id).get();

		s3FotoStorageService.remover(imagem.getNomeArquivoCompleto());

		try {
			repository.deleteById(id);
			repository.flush();

		} catch (EmptyResultDataAccessException e) {
			throw new ImagemNaoEncontradaException(id);
		}
		;

	}
}