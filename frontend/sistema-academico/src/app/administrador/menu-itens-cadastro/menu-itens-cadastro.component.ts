import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-menu-itens-cadastro',
  templateUrl: './menu-itens-cadastro.component.html',
  styleUrls: ['./menu-itens-cadastro.component.css']
})

export class MenuItensCadastroComponent implements OnInit {

  titulo: string = '';

  constructor() { }

  ngOnInit(): void {
  }

  seleciona(valor: string){
    this.titulo = valor;
    console.log(valor);
  }
}
