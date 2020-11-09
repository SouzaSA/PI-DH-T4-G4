import { Component, OnInit } from '@angular/core';

import { Administrador } from '../../shared/model/administrador.model';
import { ColumnSetting } from '../../shared/model/table-layout.model';
import { AdministradorService } from './../../service/administrador.service';

@Component({
  selector: 'app-cadastro-administradores',
  templateUrl: './cadastro-administradores.component.html',
  styleUrls: ['./cadastro-administradores.component.css']
})
export class CadastroAdministradoresComponent implements OnInit {

  title: string = ''//'Administradores';
  administradores: Administrador[];

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
      }
    ];

  constructor(private administradorService: AdministradorService) { }

  ngOnInit(): void {
    this.administradorService
      .listarAdministradores()
      .subscribe(administrador => this.administradores = administrador);
  }

}