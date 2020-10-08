package com.pi.dh.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pi.dh.domain.model.Imagem;
import com.pi.dh.dto.ImagemDTO;
import com.pi.dh.request.ImagemRequest;

@Component
public class ImagemMapper {
	
	@Autowired
	private ModelMapper modelMapper;
	
	public Imagem requestToModel(ImagemRequest imagemRequest) {
		return modelMapper.map(imagemRequest, Imagem.class);
	}
	
	public ImagemDTO modelToDTO(Imagem imagem) {
		return modelMapper.map(imagem, ImagemDTO.class);
	}
}