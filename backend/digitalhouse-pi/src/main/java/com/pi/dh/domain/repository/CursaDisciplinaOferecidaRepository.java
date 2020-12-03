package com.pi.dh.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.pi.dh.domain.model.CursaDisciplinaOferecida;

@Repository
public interface CursaDisciplinaOferecidaRepository extends JpaRepository<CursaDisciplinaOferecida, Long> {

	@Query("SELECT cdo FROM CursaDisciplinaOferecida cdo "
			+ "LEFT JOIN cdo.aluno alu WHERE alu.alunoId = ?1")
	List<CursaDisciplinaOferecida> findAllByAlunoId(Long alunoId);
	
	@Query("SELECT cdo FROM CursaDisciplinaOferecida cdo "
			+ "LEFT JOIN cdo.disciplinaOferecida disOf "
			+ "LEFT JOIN disOf.professor prof "
			+ "WHERE prof.professorId = ?1")
	List<CursaDisciplinaOferecida> findAllByProfessorId(Long professorId);
	
	@Query("SELECT cdo FROM CursaDisciplinaOferecida cdo "
			+ "LEFT JOIN cdo.disciplinaOferecida disOf "
			+ "LEFT JOIN disOf.disciplina dis "
			+ "WHERE dis.disciplinaId = ?1")
	List<CursaDisciplinaOferecida> findAllByDisciplinaId(Long disciplinaId);
	
	@Query("SELECT cdo FROM CursaDisciplinaOferecida cdo "
			+ "LEFT JOIN cdo.disciplinaOferecida disOf "
			+ "LEFT JOIN disOf.professor prof "
			+ "LEFT JOIN disOf.disciplina dis "
			+ "WHERE dis.disciplinaId = ?1 "
			+ "AND prof.professorId = ?2")
	List<CursaDisciplinaOferecida> findAllByDisciplinaIdAndProfessorId(Long disciplinaId, Long professorId);

}
