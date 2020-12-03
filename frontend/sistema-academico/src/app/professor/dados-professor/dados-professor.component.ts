import { Component, OnInit } from '@angular/core';

import { ProfessorService } from '../../service/professor.service';
import { AuthService } from '../../service/auth.service';
import { Professor } from './../../shared/model/professor.model';


@Component({
  selector: 'dados-professsor',
  templateUrl: './dados-professor.component.html',
  styleUrls: ['./dados-professor.component.css']
})
export class DadosProfessorComponent implements OnInit {

  professor: Professor;
    
  constructor(
    private professorService: ProfessorService,
    private authService: AuthService
    ) { }

  ngOnInit(): void {
    this.professorService.getProfessorPorPessoaId(this.authService.getUserIdOnToken()).subscribe(prof => this.professor = prof)
  }

}
