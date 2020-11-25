import { Component, OnInit } from '@angular/core';

import { AuthService } from './../../service/auth.service';
import { AlunoService } from './../../service/aluno.service';
import { Aluno } from './../../shared/model/aluno.model';

@Component({
  selector: 'app-dados-aluno',
  templateUrl: './dados-aluno.component.html',
  styleUrls: ['./dados-aluno.component.css']
})
export class DadosAlunoComponent implements OnInit {

  aluno: Aluno;

  constructor(
    private alunoService: AlunoService,
    private authService: AuthService
  ) { }

  ngOnInit(): void {
    this.aluno = undefined;
    this.alunoService.getAlunoPorPessoaId(this.authService.getUserIdOnToken()).subscribe(alu => this.aluno = alu)
  }

}
