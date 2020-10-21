import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';

import { AlunoFormComponent } from './aluno-form/aluno-form.component';
import { SharedModule } from '../shared/shared.module';


@NgModule({
  declarations: [
    AlunoFormComponent
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
  ]
})
export class DataFormModule { }
