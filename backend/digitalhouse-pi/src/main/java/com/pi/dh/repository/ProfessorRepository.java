package com.pi.dh.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pi.dh.model.Professor;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Long> {

}
