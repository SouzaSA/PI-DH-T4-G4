package com.pi.dh.domain.service;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pi.dh.domain.model.Informe;
import com.pi.dh.domain.model.Pessoa;
import com.pi.dh.domain.model.Professor;
import com.pi.dh.domain.model.enums.Departamentos;
import com.pi.dh.domain.model.enums.PrioridadeInforme;
import com.pi.dh.domain.repository.InformeRepository;
import com.pi.dh.domain.repository.PessoaRepository;
import com.pi.dh.domain.repository.ProfessorRepository;

@Service
public class DBService {
	
	@Autowired
	private InformeRepository informeRepository;
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	@Autowired
	private ProfessorRepository professorRepository;
	
	public void instantiateTestDatabase() throws ParseException {
		
		Pessoa pess1 = new Pessoa(null, "Santiago", "Thyago", "ssantiagotl@gmail.com", "teste123");
		
		Professor prof1 = new Professor(null, pess1, Departamentos.Dept1);
		
		Informe informe1 = new Informe(null, "teste01", "Primeiro informe de teste", prof1, PrioridadeInforme.Média, Departamentos.Dept1);

		pessoaRepository.save(pess1);
		professorRepository.save(prof1);
		informeRepository.save(informe1);
	}
}
