import { Component, OnInit } from '@angular/core';

import { AuthService } from './../service/auth.service';
import { InformesListaDepartamentoService } from '../informes-departamento/informes-lista-departamento.service';

@Component({
  selector: 'comum-menu-lateral',
  templateUrl: './menu-lateral.component.html',
  styleUrls: ['./menu-lateral.component.css']
})
export class MenuLateralComponent implements OnInit {

  constructor(
    private menu: InformesListaDepartamentoService,
    private authService: AuthService
  ) { }

  ngOnInit(): void {
  }

  setDepartamento(dpto:string): void {
    this.menu.changeDepartamento(dpto);
  }

  temPermissao(perm: string) {
    if (perm){
      return this.authService.temPermissao(perm);
    }
  }

}
