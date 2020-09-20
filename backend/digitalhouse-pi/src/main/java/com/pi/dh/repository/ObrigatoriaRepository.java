package com.pi.dh.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pi.dh.model.Obrigatoria;

@Repository
public interface ObrigatoriaRepository extends JpaRepository<Obrigatoria, Long> {

}
