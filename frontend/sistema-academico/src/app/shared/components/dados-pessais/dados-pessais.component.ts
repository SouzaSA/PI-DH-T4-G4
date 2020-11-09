import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'app-dados-pessais',
  templateUrl: './dados-pessais.component.html',
  styleUrls: ['./dados-pessais.component.css']
})

export class DadosPessaisComponent implements OnInit {

  @Input()

  constructor() { }

  ngOnInit(): void {
  }

}
