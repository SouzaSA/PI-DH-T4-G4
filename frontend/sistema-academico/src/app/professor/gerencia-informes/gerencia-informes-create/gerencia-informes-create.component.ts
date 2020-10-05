import { GerenciaInformesComponent } from './../gerencia-informes.component';
import { Informe } from './../gerencia-informes.model';
import { GerenciaInformesService } from './../gerencia-informes.service';
import { Component, OnInit } from '@angular/core';
import { SelectItem } from 'primeng/api';
import { Router } from '@angular/router';
import { MatExpansionPanel, MatExpansionModule } from '@angular/material/expansion';

interface Prioridade {
  name: string;
}

interface Departamento {
  name: string;
}

@Component({
  selector: 'app-gerencia-informes-create',
  templateUrl: './gerencia-informes-create.component.html',
  styleUrls: ['./gerencia-informes-create.component.css'],
})
export class GerenciaInformesCreateComponent implements OnInit {
  prioridades: Prioridade[] = [
    { name: 'Baixa'},
    { name: 'Média'},
    { name: 'Alta'},
    { name: 'Urgente'},
  ];
  departamentos: Departamento[] = [
    { name: 'Dep1'},
    { name: 'Dep2'},
    { name: 'Dep3'},
    { name: 'Dep4'},
  ];

  prioridadeSelecionada: Prioridade;

  departamentoSelecionado: Departamento;
  informe: Informe = {
    titulo: '',
    descricao: '',
    prioridade: null,
    departamento: null,
  };


  constructor(
    private gerenciaInformesService: GerenciaInformesService,
    private router: Router,
    private gerenciaInformes: GerenciaInformesComponent
  ) {}

  ngOnInit(): void {}

  createInforme(): void {
    
    this.gerenciaInformesService.create(this.informe).subscribe(() => {
      this.gerenciaInformesService.showMessage('Informe criado.');
      this.router.navigate(['/informes']);
    });
  }

  cancel(mep: MatExpansionPanel): void {
    if(mep.expanded){
      mep.close()
    };
  }
}
