package com.pi.dh.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pi.dh.domain.model.Informe;

@Repository
public interface InformeRepository extends JpaRepository<Informe, Long> {

	//@Query("FROM Informe inf WHERE inf.departamento = ?1")
	List<Informe> findAllByDepartamento(int departamento);

}
