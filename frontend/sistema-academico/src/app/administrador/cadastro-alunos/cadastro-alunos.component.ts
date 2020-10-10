import { Component, OnInit } from '@angular/core';

import { Aluno } from './../../model/aluno.model';
import { AdministradorService } from './../../service/administrador.service';
import { ColumnSetting } from './../../model/table-layout.model';

@Component({
  selector: 'app-cadastro-alunos',
  templateUrl: './cadastro-alunos.component.html',
  styleUrls: ['./cadastro-alunos.component.css']
})

export class CadastroAlunosComponent implements OnInit {

  title: string = 'Alunos';
  alunos: Aluno[];

  projectSettings: ColumnSetting[] = 
    [
      {
        primaryKey: 'id',
        header: 'Código'
      },
      {
        primaryKey: 'nome',
        header: 'Nome'
      },
      {
        primaryKey: 'email',
        header: 'E-mail'
      },
      {
        primaryKey: 'cep',
        header: 'CEP'
      },
      {
        primaryKey: 'rua',
        header: 'Logradouro'
      },
      {
        primaryKey: 'numero',
        header: 'Número'
      },
      {
        primaryKey: 'bairro',
        header: 'Bairro'
      },
      {
        primaryKey: 'complemento',
        header: 'Complemento'
      },
      {
        primaryKey: 'cidade',
        header: 'Cidade'
      },
      {
        primaryKey: 'estado',
        header: 'UF'
      },
      {
        primaryKey: 'telefone',
        header: 'Telefone'
      },
      {
        primaryKey: 'curso',
        header: 'Curso'
      }
    ];

  constructor(private administradorService: AdministradorService) { }

  ngOnInit(): void {
    this.administradorService.listarAlunos().subscribe(aluno => this.alunos = aluno);
    console.log(this.alunos);
  }

}