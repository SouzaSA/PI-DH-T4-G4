package com.pi.dh.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pi.dh.model.CursaDisciplinaOferecida;

@Repository
public interface CursaDisciplinaOferecidaRepository extends JpaRepository<CursaDisciplinaOferecida, Long> {

}
