package com.pi.dh.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.pi.dh.domain.model.Aluno;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long> {

	@Query("SELECT alu FROM Aluno alu LEFT JOIN alu.pessoa pess WHERE pess.pessoaId = ?1")
	Aluno getAlunoIdByPessoaId(Long id);
}
