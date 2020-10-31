import { AdministradorService } from './../../service/administrador.service';
import { ColumnSetting } from './../../shared/model/table-layout.model';
import { DisciplinaOferecida } from './../../shared/model/disciplina-oferecida.model';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-cadastro-disciplina-oferecida',
  templateUrl: './cadastro-disciplina-oferecida.component.html',
  styleUrls: ['./cadastro-disciplina-oferecida.component.css']
})
export class CadastroDisciplinaOferecidaComponent implements OnInit {

  title: string = ''//'Alunos';
  disciplinasOferecidas: DisciplinaOferecida[];

  projectSettings: ColumnSetting[] = 
    [
      {
        primaryKey: 'disciplinaOferecidaId',
        header: 'Código'
      },
      {
        primaryKey: 'nome',
        header: 'Nome'
      },
      {
        primaryKey: 'horario',
        header: 'Horário'
      },
      {
        primaryKey: 'professor',
        header: 'Professor'
      },
      {
        primaryKey: 'disciplina',
        header: 'Disciplina'
      },
      {
        primaryKey: 'sala',
        header: 'Sala'
      },
      {
        primaryKey: 'semestre',
        header: 'Semestre'
      },
      {
        primaryKey: 'ano',
        header: 'Ano'
      }
    ];

  constructor(private administradorService: AdministradorService) { }

  ngOnInit(): void {
    this.administradorService.listarDisciplinasOferecidas().subscribe(disciplinaOferecida => this.disciplinasOferecidas = disciplinaOferecida);
  }

}
