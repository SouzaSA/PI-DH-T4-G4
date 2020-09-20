package com.pi.dh.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pi.dh.model.Sala;

@Repository
public interface SalaRepository extends JpaRepository<Sala, Long> {

}
