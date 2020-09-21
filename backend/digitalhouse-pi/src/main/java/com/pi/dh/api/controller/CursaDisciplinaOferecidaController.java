package com.pi.dh.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pi.dh.domain.model.CursaDisciplinaOferecida;
import com.pi.dh.domain.repository.CursaDisciplinaOferecidaRepository;

@RestController
@RequestMapping("/cursaDisciplinasOferecidas")
public class CursaDisciplinaOferecidaController {

	@Autowired
	private CursaDisciplinaOferecidaRepository cursaDisciplinaOferecidaRepository;
	
	@PostMapping
	public void salvar(@RequestBody CursaDisciplinaOferecida cursaDisciplinaOferecida) {
		cursaDisciplinaOferecidaRepository.save(cursaDisciplinaOferecida);
	}
	
	@GetMapping
	public List<CursaDisciplinaOferecida> listar() {
		return cursaDisciplinaOferecidaRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public CursaDisciplinaOferecida buscar(@PathVariable Long id) {
		return cursaDisciplinaOferecidaRepository.findById(id).get();
	}
	
	@DeleteMapping("/{id}")
	public void excluir(@PathVariable Long id) {
		cursaDisciplinaOferecidaRepository.deleteById(id);
	}
	
	@PutMapping("/{id}")
	public void atualizar(@RequestBody CursaDisciplinaOferecida cursaDisciplinaOferecida, @PathVariable Long id) {
		CursaDisciplinaOferecida cdo = cursaDisciplinaOferecidaRepository.findById(id).get();
		
		cdo.setDataInscricao(cursaDisciplinaOferecida.getDataInscricao());
		cdo.setData_deferimento(cursaDisciplinaOferecida.getData_deferimento());
		cdo.setAluno(cursaDisciplinaOferecida.getAluno());
		cdo.setDisciplinaOferecida(cursaDisciplinaOferecida.getDisciplinaOferecida());

		
		cursaDisciplinaOferecidaRepository.save(cdo);
	}
}
