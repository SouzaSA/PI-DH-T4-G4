import { Component, OnInit } from '@angular/core';

import { InformesListaService } from './informes-lista.service';
import { Informe } from './informes';

@Component({
  selector: 'app-informes-geral',
  templateUrl: './informes-geral.component.html',
  styleUrls: ['./informes-geral.component.css']
})
export class InformesGeralComponent implements OnInit {

  informes: Informe[];

  constructor(private service:InformesListaService) { }

  ngOnInit(): void {
    this.service.listar().subscribe(dados => this.informes = dados);
  }

}
