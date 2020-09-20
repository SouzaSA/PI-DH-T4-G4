package com.pi.dh.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pi.dh.model.Requere;

@Repository
public interface RequereRepository extends JpaRepository<Requere, Long> {

}
