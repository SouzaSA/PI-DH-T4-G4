package com.pi.dh.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pi.dh.model.Administrador;

@Repository
public interface AdministradorRepository extends JpaRepository<Administrador, Long> {

}
