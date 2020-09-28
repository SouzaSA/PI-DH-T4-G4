import { Component, OnInit } from '@angular/core';
import { MatExpansionPanel } from '@angular/material/expansion';

@Component({
  selector: 'app-gerencia-informes',
  templateUrl: './gerencia-informes.component.html',
  styleUrls: ['./gerencia-informes.component.css']
})
export class GerenciaInformesComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }
  

  togglePanel(panel: MatExpansionPanel) {
    panel.close();
  }
  
  display: boolean = false;

  showDialog() {
    this.display = true;
  }



}


