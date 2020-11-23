import { Component, OnInit } from '@angular/core';

import { AuthService } from './../../service/auth.service';
import { AdministradorService } from './../../service/administrador.service';
import { Administrador } from 'src/app/shared/model/administrador.model';

@Component({
  selector: 'dados-administrador',
  templateUrl: './dados-administrador.component.html',
  styleUrls: ['./dados-administrador.component.css']
})
export class DadosAdministradorComponent implements OnInit {

  administrador: Administrador;

  constructor(
    private administradorService: AdministradorService,
    private authService: AuthService
  ) { }

  ngOnInit(): void {
    this.administradorService.getAdministradorPorPessoaId(this.authService.getUserIdOnToken()).subscribe(prof => this.administrador = prof)
  }

}
