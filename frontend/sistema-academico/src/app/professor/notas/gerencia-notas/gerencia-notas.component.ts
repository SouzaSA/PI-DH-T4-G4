import { DisciplinaDto } from './../../../shared/dto/disciplina.dto';
import { Component, OnInit } from '@angular/core';

import { CursaDisciplinaOferecidaDto } from 'src/app/shared/dto/cursa-disciplina-oferecida.dto';
import { NotasService } from '../../../service/notas.service';

@Component({
  selector: 'app-gerencia-notas',
  templateUrl: './gerencia-notas.component.html',
  styleUrls: ['./gerencia-notas.component.css'],
})
export class GerenciaNotasComponent implements OnInit {
  turmas: CursaDisciplinaOferecidaDto[];
  disciplinas: DisciplinaDto[];

  constructor(private notasService: NotasService) {}

  ngOnInit() {
    // this.notasService.getTurma().subscribe((turmas) => {
    //   this.turmas = turmas;
    // });
    this.notasService.getDisciplina().subscribe((disciplinas) => {
      this.disciplinas = disciplinas;
    });
  }
}
