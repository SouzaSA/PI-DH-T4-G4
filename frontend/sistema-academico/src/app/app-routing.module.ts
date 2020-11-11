import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { DadosPessoaisComponent } from './shared/components/dados-pessoais/dados-pessoais.component';
import { DadosProfessorComponent } from './professor/dados-professor/dados-professor.component';
import { ProfessorComponent } from './professor/professor.component';
import { InformesGeralComponent } from './informes-geral/informes-geral.component';
import { InformesDepartamentoComponent } from './informes-departamento/informes-departamento.component';

import { AdministradorComponent } from './administrador/administrador.component';
import { MenuItensCadastroComponent } from './administrador/menu-itens-cadastro/menu-itens-cadastro.component';
import { NotasComponent } from './professor/notas/notas.component';
import { InformesComponent } from './professor/informes/informes.component';

const routes: Routes = [
  { path: 'departamento', component: InformesGeralComponent },
  { path: '', component: InformesGeralComponent },
  { path: 'departamento1', component: InformesDepartamentoComponent },
  { path: 'departamento2', component: InformesDepartamentoComponent },
  { path: 'departamento3', component: InformesDepartamentoComponent },
  { path: 'departamento4', component: InformesDepartamentoComponent },
  {
    path: 'professor',
    component: ProfessorComponent,
    children: [
      { path: '', component: DadosProfessorComponent },
      { path: 'informes', component: InformesComponent },
      { path: 'notas', component: NotasComponent },
    ],
  },
  {
    path: 'administrador',
    component: AdministradorComponent,
    children: [
      { path: '', component: DadosPessoaisComponent },
      { path: 'cadastro', component: MenuItensCadastroComponent },
    ],
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
