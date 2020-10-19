import { Aluno, Disciplina, Turma, Professor } from '../notas.model';
import { NotasService } from '../../../service/notas.service';
import { Component, OnInit, ViewChild } from '@angular/core';
import { Table } from 'primeng/table';

@Component({
  selector: 'app-gerencia-notas',
  templateUrl: './gerencia-notas.component.html',
  styleUrls: ['./gerencia-notas.component.css'],
})
export class GerenciaNotasComponent implements OnInit {
  turmas: Turma[];
  cols: any[];
  disciplinas: Disciplina[];
  selectedDisciplina: Disciplina;

  
  
  constructor(private notasService: NotasService) {}

  ngOnInit() {
    this.notasService.getTurma().subscribe((turmas) => {
      this.turmas = turmas;
    });

    this.disciplinas = [
      { id: 1, nome: 'DISC1' },
      { id: 2, nome: 'DISC2' },
      { id: 3, nome: 'DISC3' },
      { id: 4, nome: 'DISC4' },
    ];
  }
}
