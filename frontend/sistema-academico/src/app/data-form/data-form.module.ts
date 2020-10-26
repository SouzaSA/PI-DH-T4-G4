import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';

import { AlunoFormComponent } from './aluno-form/aluno-form.component';
import { SharedModule } from '../shared/shared.module';
import { ProfessorFormComponent } from './professor-form/professor-form.component';
import { EnderecoFormComponent } from './endereco-form/endereco-form.component';
import { PessoaFormComponent } from './pessoa-form/pessoa-form.component';


@NgModule({
  declarations: [
    AlunoFormComponent,
    ProfessorFormComponent,
    EnderecoFormComponent,
    PessoaFormComponent
  ],
  imports: [
    SharedModule,
    CommonModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule
  ],
  exports: [
    AlunoFormComponent,
    ProfessorFormComponent,
    EnderecoFormComponent,
    PessoaFormComponent
  ]
})
export class DataFormModule { }
