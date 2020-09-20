package com.pi.dh.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pi.dh.model.Nota;

@Repository
public interface NotaRepository extends JpaRepository<Nota, Long> {

}
