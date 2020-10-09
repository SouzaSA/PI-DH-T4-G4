import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { GerenciaInformesComponent } from './professor/gerencia-informes/gerencia-informes.component';
import { DadosPessaisComponent } from './dados-pessais/dados-pessais.component';
import { ProfessorComponent } from './professor/professor.component';
import { InformesGeralComponent } from './informes-geral/informes-geral.component';
import { InformesDepartamentoComponent } from './informes-departamento/informes-departamento.component';
import { GerenciaInformesUpdateComponent } from './professor/gerencia-informes/gerencia-informes-update/gerencia-informes-update.component';
import { GerenciaInformesDeleteComponent } from './professor/gerencia-informes/gerencia-informes-delete/gerencia-informes-delete.component';
import { AdministradorComponent } from './administrador/administrador.component';
import { MenuItensCadastroComponent } from './administrador/menu-itens-cadastro/menu-itens-cadastro.component';

const routes: Routes = [
  { path: 'departamento', component: InformesGeralComponent },
  { path: '', component: InformesGeralComponent },
  { path: 'departamento1', component: InformesDepartamentoComponent },
  { path: 'departamento2', component: InformesDepartamentoComponent },
  { path: 'departamento3', component: InformesDepartamentoComponent },
  {
    path: 'professor',
    component: ProfessorComponent,
    children: [
      { path: '', component: DadosPessaisComponent },
      { path: 'informes', component: GerenciaInformesComponent },
    ],
  },
  {
    path: 'professor/informes/update/:id',
    component: GerenciaInformesUpdateComponent,
  },
  {
    path: 'professor/informes/delete/:id',
    component: GerenciaInformesDeleteComponent,
  },
  {
    path: 'administrador', component: AdministradorComponent,
    children: [
      { path: '', component: DadosPessaisComponent },
      { path: 'cadastro', component: MenuItensCadastroComponent },
    ],
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
