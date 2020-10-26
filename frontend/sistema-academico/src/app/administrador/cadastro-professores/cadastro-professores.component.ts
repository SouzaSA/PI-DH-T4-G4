import { Component, OnInit } from '@angular/core';

import { AdministradorService } from '../../service/administrador.service';
import { ColumnSetting } from '../../shared/model/table-layout.model';
import { Professor } from '../../shared/model/professor.model';

@Component({
  selector: 'app-cadastro-professores',
  templateUrl: './cadastro-professores.component.html',
  styleUrls: ['./cadastro-professores.component.css']
})
export class CadastroProfessoresComponent implements OnInit {

  title: string = ''//'Professores';
  professores: Professor[];

  projectSettings: ColumnSetting[] = 
    [
      {
        primaryKey: 'professorId',
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
        primaryKey: 'departamento',
        header: 'Departamento'
      }
    ];

  constructor(private administradorService: AdministradorService) { }

  ngOnInit(): void {
    this.administradorService.listarProfessores().subscribe(professor => this.professores = professor);
  }

}