import { Component, OnInit } from '@angular/core';

import { Disciplina } from './../../shared/model/disciplina.model';
import { AdministradorService } from '../../service/administrador.service';
import { ColumnSetting } from '../../shared/model/table-layout.model';

@Component({
  selector: 'app-cadastro-disciplinas',
  templateUrl: './cadastro-disciplinas.component.html',
  styleUrls: ['./cadastro-disciplinas.component.css']
})
export class CadastroDisciplinasComponent implements OnInit {

  title: string = ''//'Alunos';
  disciplinas: Disciplina[];

  projectSettings: ColumnSetting[] = 
    [
      {
        primaryKey: 'disciplinaId',
        header: 'Código'
      },
      {
        primaryKey: 'creditos',
        header: 'Créditos'
      },
      {
        primaryKey: 'ementa',
        header: 'Ementa'
      },
      {
        primaryKey: 'nome',
        header: 'Nome'
      },
      {
        primaryKey: 'semestreIdeal',
        header: 'Semestre Ideal'
      },
      {
        primaryKey: 'requeridas',
        header: 'Requeridas'
      }
    ];

  constructor(private administradorService: AdministradorService) { }

  ngOnInit(): void {
    this.administradorService.listarDisciplinas().subscribe(disciplina => this.disciplinas = disciplina);
  }

}
