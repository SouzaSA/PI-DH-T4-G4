package com.pi.dh.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pi.dh.domain.model.Foto;

@Repository
public interface FotoRepository extends JpaRepository<Foto, Long>{

}
