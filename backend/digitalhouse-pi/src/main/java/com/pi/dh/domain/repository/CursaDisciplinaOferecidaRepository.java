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
	List<CursaDisciplinaOferecida> findAllByAlunoId(Long id);

}
