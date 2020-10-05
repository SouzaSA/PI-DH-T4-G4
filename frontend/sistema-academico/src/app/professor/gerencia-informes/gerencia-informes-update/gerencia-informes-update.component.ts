import { GerenciaInformesService } from './../gerencia-informes.service';
import { Component, Inject, OnInit, Optional } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Informe } from '../gerencia-informes.model';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';

export interface Prioridade {
  name: string;
}

export interface Departamento {
  name: string;
}


@Component({
  selector: 'app-gerencia-informes-update',
  templateUrl: './gerencia-informes-update.component.html',
  styleUrls: ['./gerencia-informes-update.component.css'],
})
export class GerenciaInformesUpdateComponent implements OnInit {
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

  informe: Informe;

  constructor(
    private gerenciaInformesService: GerenciaInformesService,
    private router: Router,
    private route: ActivatedRoute,
  ) {}

  ngOnInit(): void {
    const id = +this.route.snapshot.paramMap.get('id');
    this.gerenciaInformesService.readById(id).subscribe((informe) => {
      this.informe = informe;
    });
  }

  updateInforme(): void {
    this.gerenciaInformesService.update(this.informe).subscribe(() => {
      this.gerenciaInformesService.showMessage(
        'Informe atualizado com sucesso.'
      );
      this.router.navigate(['professor/informes']);
    });
  }

  cancel(): void {
    this.router.navigate(['professor/informes']);
  }
}
