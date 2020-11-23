import { Component, Input, OnChanges, OnInit } from '@angular/core';

@Component({
  selector: 'dados-pessoais',
  templateUrl: './dados-pessoais.component.html',
  styleUrls: ['./dados-pessoais.component.css']
})

export class DadosPessoaisComponent implements OnChanges {

  @Input()
  usuario?: any;

  constructor() { }

  ngOnChanges(): void {
  }

}
