package com.pi.dh.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pi.dh.domain.model.Imagem;

@Repository
public interface ImagemRepository extends JpaRepository<Imagem, Long>{
	
}