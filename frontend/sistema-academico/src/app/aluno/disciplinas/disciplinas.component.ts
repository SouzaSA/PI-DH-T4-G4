import { AuthService } from './../../service/auth.service';
import { Component, OnInit } from '@angular/core';

import { DropdownService } from './../../service/dropdown.service';
import { AlunoService } from './../../service/aluno.service';
import { CursaDisciplinaOferecidaDto } from '../../shared/dto/cursa-disciplina-oferecida.dto';
import { Aluno } from 'src/app/professor/notas/notas.model';

@Component({
  selector: 'app-disciplinas',
  templateUrl: './disciplinas.component.html',
  styleUrls: ['./disciplinas.component.css']
})
export class DisciplinasComponent implements OnInit {

  aluno: Aluno;
  diasSemana: string[];
  horarios: string[];
  disciplinasCursadas: CursaDisciplinaOferecidaDto[];
  grade: String[][];

  constructor(
    private dropdownService: DropdownService,
    private alunoService: AlunoService,
    private authService: AuthService
  ) { }

  ngOnInit(): void {

    this.getDiasSemana();
    this.getHorarios();

    this.alunoService.getAlunoPorPessoaId(this.authService.getUserIdOnToken()).subscribe(alu => this.aluno = alu),

    this.alunoService.getCursaDisciplinaOferecida(+sessionStorage.getItem('alunoId')).subscribe(disciplinasCursadas => this.disciplinasCursadas = disciplinasCursadas)
  
    this.geraGradeHorario();
  }

  geraGradeHorario() {    

    for (let index = 1; index < this.diasSemana.length+1; index++) {
      this.grade[index][0] = this.diasSemana[index-1];
    }

    for (let index = 0; index < this.horarios.length; index++) {
      this.grade[0][index] = this.horarios[index];
    }

    this.disciplinasCursadas.forEach(element => {
      this.grade[
        this.diasSemana.indexOf(element.disciplinaOferecida.diaSemana)+1
      ][
        this.horarios.indexOf(element.disciplinaOferecida.horario)
      ] = element.disciplinaOferecida.disciplina.codigo;
    });

  }

  async getDiasSemana() {
    this.dropdownService.getDias().subscribe(dados => this.diasSemana = dados);
  }

  getHorarios() {
    this.dropdownService.getHorarios().subscribe(dados => this.horarios = dados);
  }
}
