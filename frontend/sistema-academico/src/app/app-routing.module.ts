
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { MenuLateralComponent } from './menu-lateral/menu-lateral.component';
import { InformesGeralComponent } from './informes-geral/informes-geral.component';
import { InformesDepartamentoComponent } from './informes-departamento/informes-departamento.component'

const routes: Routes = [
  {path: '', component: MenuLateralComponent, children: [
    {path: 'departamento', component: InformesGeralComponent },
    {path: 'departamento1', component: InformesDepartamentoComponent },
    {path: 'departamento2', component: InformesDepartamentoComponent },
    {path: 'departamento3', component: InformesDepartamentoComponent },
  ]},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
