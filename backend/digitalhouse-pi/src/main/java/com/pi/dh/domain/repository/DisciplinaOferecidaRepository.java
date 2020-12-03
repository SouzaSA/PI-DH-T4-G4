package com.pi.dh.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.pi.dh.domain.model.DisciplinaOferecida;

@Repository
public interface DisciplinaOferecidaRepository extends JpaRepository<DisciplinaOferecida, Long> {
	
	@Query("SELECT disOf FROM DisciplinaOferecida disOf LEFT JOIN disOf.professor prof WHERE prof.professorId = ?1")
	List<DisciplinaOferecida> findAllByProfessor(Long professorId);

}
