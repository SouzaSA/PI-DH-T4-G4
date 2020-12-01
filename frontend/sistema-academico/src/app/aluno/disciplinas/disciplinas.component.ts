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

    this.alunoService.getAlunoPorPessoaId(this.authService.getUserIdOnToken()).subscribe(alu => this.aluno = alu);

    this.alunoService.getCursaDisciplinaOferecida(+sessionStorage.getItem('alunoId')).subscribe(disciplinasCursadas => {
      this.disciplinasCursadas = disciplinasCursadas
      if (!this.grade && this.disciplinasCursadas && this.diasSemana){
        this.geraGradeHorario();
      }
    });
  
    this.carregaGrade();
  }

  geraGradeHorario() {    

    this.grade = [];

    //inicializa a grade
    for (let i = 0; i < this.horarios.length+1; i++) {
      this.grade[i] = []
      for (let j = 0; j < this.diasSemana.length+1; j++) {
        this.grade[i][j] = '';
        if (i == 0 && j != 0){
          
          this.grade[i][j] = this.diasSemana[j-1];
        }
        if (i != 0 && j == 0) {
          this.grade[i][j] = this.horarios[i-1];
        }
      } 
    }
    this.disciplinasCursadas.forEach(element => {
      element.disciplinaOferecida.diasHoras.forEach( diaHora => {
        console.log(diaHora.horario + " " + diaHora.diaSemana);
        this.grade[
          this.horarios.indexOf(diaHora.horario)+1
        ][
          this.diasSemana.indexOf(diaHora.diaSemana)+1
        ] = element.disciplinaOferecida.disciplina.codigo;
      })
    });
  }

  //gambiarra
  carregaGrade() {
    this.dropdownService.getDias().subscribe(dados => {
      this.diasSemana = dados;
      if (!this.grade && this.disciplinasCursadas && this.horarios){
        this.geraGradeHorario();
      }
    });
    this.dropdownService.getHorarios().subscribe(dados => {
      this.horarios = dados;
      if (!this.grade && this.disciplinasCursadas && this.diasSemana){
        this.geraGradeHorario();
      }
    });

    
  }

}
