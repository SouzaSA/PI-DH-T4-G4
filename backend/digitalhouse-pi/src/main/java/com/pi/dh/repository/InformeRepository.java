package com.pi.dh.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pi.dh.model.Informe;

@Repository
public interface InformeRepository extends JpaRepository<Informe, Long> {

}
