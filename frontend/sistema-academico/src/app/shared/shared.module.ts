import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

import {MatIconModule} from '@angular/material/icon';

import { BsDropdownModule } from 'ngx-bootstrap/dropdown';

import { SharedRoutingModule } from './shared-routing.module';
import { DadosPessoaisComponent } from './components/dados-pessoais/dados-pessoais.component';
import { TableLayoutComponent } from './components/table-layout/table-layout.component';
import { FormDebugComponent } from './components/form-debug/form-debug.component';
import { CampoControlErroComponent } from './components/campo-control-erro/campo-control-erro.component';
import { ErrorMsgComponent } from './components/error-msg/error-msg.component';
import { PageSpinnerComponent } from './components/page-spinner/page-spinner.component';



@NgModule({
  declarations: [ 
    DadosPessoaisComponent,
    TableLayoutComponent,
    FormDebugComponent,
    CampoControlErroComponent,
    ErrorMsgComponent,
    PageSpinnerComponent
   ],
  imports: [
    CommonModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
    MatIconModule,
    BrowserAnimationsModule,
    BsDropdownModule
  ],
  exports: [
    SharedRoutingModule,
    DadosPessoaisComponent,
    TableLayoutComponent,
    FormDebugComponent,
    CampoControlErroComponent,
    ErrorMsgComponent,
    PageSpinnerComponent
  ]
})
export class SharedModule { }

