import { Disciplina, Turma } from '../notas.model';
import { NotasService } from '../../../service/notas.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-gerencia-notas',
  templateUrl: './gerencia-notas.component.html',
  styleUrls: ['./gerencia-notas.component.css'],
})
export class GerenciaNotasComponent implements OnInit {
  turmas: Turma[];
  disciplinas: Disciplina[];

  constructor(private notasService: NotasService) {}

  ngOnInit() {
    this.notasService.getTurma().subscribe((turmas) => {
      this.turmas = turmas;
    });
    this.notasService.getDisciplina().subscribe((disciplinas) => {
      this.disciplinas = disciplinas;
    });
  }
}
