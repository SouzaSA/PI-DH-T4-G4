package com.pi.dh.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pi.dh.domain.model.Professor;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Long> {
	
	@Query(value = "SELECT prof.professorId FROM Professor prof WHERE prof.pessoa.pessoaId = id")
	Long getProfessorIdByPessoaId(@Param("id") long id);

}
