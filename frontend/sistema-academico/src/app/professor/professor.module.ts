import { SharedModule } from './../shared/shared.module';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { DadosProfessorComponent } from './dados-professor/dados-professor.component';

@NgModule({
  declarations: [
    DadosProfessorComponent
  ],
  imports: [
    CommonModule,
    SharedModule
  ],
  exports: [
    DadosProfessorComponent
  ]
})
export class ProfessorModule { }
