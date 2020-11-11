package com.pi.dh.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.pi.dh.domain.model.Professor;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Long> {
	
	@Query("SELECT prof FROM Professor prof LEFT JOIN prof.pessoa pess WHERE pess.pessoaId = ?1")
	Professor getProfessorIdByPessoaId(Long id);

}