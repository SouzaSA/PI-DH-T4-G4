import { Component, OnInit } from '@angular/core';

import { AdministradorService } from '../../service/administrador.service';
import { ColumnSetting } from '../../shared/model/table-layout.model';
import { Sala } from '../../shared/model/sala.model';

@Component({
  selector: 'app-cadastro-salas',
  templateUrl: './cadastro-salas.component.html',
  styleUrls: ['./cadastro-salas.component.css']
})
export class CadastroSalasComponent implements OnInit {

  title: string = ''//'Salas';
  salas: Sala[];

  projectSettings: ColumnSetting[] = 
    [
      {
        primaryKey: 'salaId',
        header: 'Código'
      },
      {
        primaryKey: 'numero',
        header: 'Número'
      },
      {
        primaryKey: 'departamento',
        header: 'Departamento'
      },
      {
        primaryKey: 'capacidade',
        header: 'Capacidade'
      },
      {
        primaryKey: 'andar',
        header: 'Andar'
      }
    ];

  constructor(private administradorService: AdministradorService) { }

  ngOnInit(): void {
    this.administradorService.listarSalas().subscribe(sala => this.salas = sala);
  }
}
