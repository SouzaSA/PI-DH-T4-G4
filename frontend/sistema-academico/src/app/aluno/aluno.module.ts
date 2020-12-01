import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { MenuAlunoItensComponent } from './menu-aluno-itens/menu-aluno-itens.component';
import { DisciplinasComponent } from './disciplinas/disciplinas.component';
import { HistoricoComponent } from './historico/historico.component';
import { DadosAlunoComponent } from './dados-aluno/dados-aluno.component';
import { InscricaoAlunoComponent } from './inscricao-aluno/inscricao-aluno.component';
import { PageSpinnerComponent } from './../shared/components/page-spinner/page-spinner.component';
import { DataFormModule } from './../data-form/data-form.module';
import { SharedModule } from './../shared/shared.module';
import { AlunoComponent } from './aluno.component';


@NgModule({
  declarations: [
    AlunoComponent,
    MenuAlunoItensComponent,
    DisciplinasComponent,
    HistoricoComponent,
    DadosAlunoComponent,
    InscricaoAlunoComponent
  ],
  imports: [
    CommonModule,
    SharedModule, 
    DataFormModule 
  ],
  exports: [
    AlunoComponent,
    MenuAlunoItensComponent,
    DisciplinasComponent,
    HistoricoComponent,
    DadosAlunoComponent,
    InscricaoAlunoComponent
  ]
})
export class AlunoModule { }
