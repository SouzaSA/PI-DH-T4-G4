import { Component, OnInit } from '@angular/core';

import { Informe } from '../informes-geral/informes';
import { InformesListaDepartamentoService } from './informes-lista-departamento.service';


@Component({
  selector: 'app-informes-departamento',
  templateUrl: './informes-departamento.component.html',
  styleUrls: ['./informes-departamento.component.css']
})
export class InformesDepartamentoComponent implements OnInit {

  informes:Informe[];

  constructor(private service: InformesListaDepartamentoService) { }

  ngOnInit(): void {
    this.service.listar().subscribe(dados => this.informes = dados.filter((dado) => dado.departamento == this.service.departamento));
  }

  setDepartamento(dpto: string){
    console.log(dpto);
  }

}
