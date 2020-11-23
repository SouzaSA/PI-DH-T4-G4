package com.pi.dh.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pi.dh.domain.model.Permissao;

public interface PermissaoRepository extends JpaRepository<Permissao, Long> {
	
}
