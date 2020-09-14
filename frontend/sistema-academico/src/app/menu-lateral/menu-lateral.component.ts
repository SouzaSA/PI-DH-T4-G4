import { Component, OnInit } from '@angular/core';

import { InformesListaDepartamentoService } from '../informes-departamento/informes-lista-departamento.service';

@Component({
  selector: 'comum-menu-lateral',
  templateUrl: './menu-lateral.component.html',
  styleUrls: ['./menu-lateral.component.css']
})
export class MenuLateralComponent implements OnInit {

  constructor(private menu: InformesListaDepartamentoService) { }

  ngOnInit(): void {
  }

  setDepartamento(dpto:string): void {
    this.menu.changeDepartamento(dpto);
  }

}
