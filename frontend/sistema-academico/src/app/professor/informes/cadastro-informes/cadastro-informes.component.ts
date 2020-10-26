import { Component, OnInit } from '@angular/core';
import { Informe } from '../../../shared/model/informes.model';
import { InformesService } from 'src/app/service/informes.service';

interface Prioridade {
  name: string;
}

interface Departamento {
  name: string;
}

@Component({
  selector: 'app-cadastro-informes',
  templateUrl: './cadastro-informes.component.html',
  styleUrls: ['./cadastro-informes.component.css'],
})
export class CadastroInformesComponent implements OnInit {
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

  activeState: boolean;
  constructor(private informesService: InformesService) {}

  ngOnInit(): void {}

  criarInforme(): void {
    this.informesService.adicionarInforme(this.informe).subscribe(() => {
      this.informesService.showMessage('Informe criado.');
      this.activeState = !this.activeState;
    });
  }

  cancel(): void {
    this.activeState = !this.activeState;
  }
}
