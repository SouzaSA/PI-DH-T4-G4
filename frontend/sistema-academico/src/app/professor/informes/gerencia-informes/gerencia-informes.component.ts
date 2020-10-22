import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Informe } from 'src/app/model/informes.model';
import { InformesService } from 'src/app/service/informes.service';

export interface Prioridade {
  name: string;
}

export interface Departamento {
  name: string;
}

@Component({
  selector: 'app-gerencia-informes',
  templateUrl: './gerencia-informes.component.html',
  styleUrls: ['./gerencia-informes.component.css'],
})
export class GerenciaInformesComponent implements OnInit {
  informe: Informe;
  displayEditar: boolean = false;
  displayDeletar: boolean = false;
  prioridades: Prioridade[] = [
    { name: 'Baixa' },
    { name: 'Média' },
    { name: 'Alta' },
    { name: 'Urgente' },
  ];
  departamentos: Departamento[] = [
    { name: 'Dep1' },
    { name: 'Dep2' },
    { name: 'Dep3' },
    { name: 'Dep4' },
  ];

  prioridadeSelecionada: Prioridade;

  departamentoSelecionado: Departamento;

  informeSelecionado: Informe;

  constructor(
    private informesService: InformesService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.listaInformes();
  }

  listaInformes() {
    this.informesService
      .listarInforme()
      .subscribe((informes) => (this.informe = informes as any));
  }

  atualizarInforme(informe: any) {
    this.informesService.atualizarInforme(this.informe).subscribe(() => {
      this.informesService.showMessage('Informe atualizado com sucesso.');
      this.displayEditar = false;
    });
  }

  janelaEditar(informe: any) {
    this.displayEditar = true;
    return (this.informeSelecionado = informe);
  }

  cancel() {
    this.displayEditar = false;
    this.displayDeletar = false;
  }

  excluir(id: number) {
    this.displayDeletar = true;
    return (this.informeSelecionado.id = id);
  }

  delete(id: number) {
    this.informesService.deletarInforme(id).subscribe(() => {
      this.displayDeletar = false;
    });
  }
}
