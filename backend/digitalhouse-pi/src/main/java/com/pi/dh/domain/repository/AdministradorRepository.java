package com.pi.dh.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.pi.dh.domain.model.Administrador;

@Repository
public interface AdministradorRepository extends JpaRepository<Administrador, Long> {

	@Query("SELECT adm FROM Administrador adm LEFT JOIN adm.pessoa pess WHERE pess.pessoaId = ?1")
	Administrador getAdministradorIdByPessoaId(Long id);
	
}
