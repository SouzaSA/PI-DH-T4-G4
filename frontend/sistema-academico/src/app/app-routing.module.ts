import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { GerenciaInformesComponent } from './professor/gerencia-informes/gerencia-informes.component';
import { DadosPessaisComponent } from './dados-pessais/dados-pessais.component';
import { ProfessorComponent } from './professor/professor.component';
import { InformesGeralComponent } from './informes-geral/informes-geral.component';
import { InformesDepartamentoComponent } from './informes-departamento/informes-departamento.component'

const routes: Routes = [
  {path: 'departamento', component: InformesGeralComponent },
  {path: '', component: InformesGeralComponent },
  {path: 'departamento1', component: InformesDepartamentoComponent },
  {path: 'departamento2', component: InformesDepartamentoComponent },
  {path: 'departamento3', component: InformesDepartamentoComponent },
  {path: 'professor', component: ProfessorComponent, children: [
    {path: '', component: DadosPessaisComponent },
    {path: 'informes', component: GerenciaInformesComponent},
  ] },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
