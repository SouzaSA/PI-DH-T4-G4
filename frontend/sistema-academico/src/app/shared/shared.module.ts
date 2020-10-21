import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

import { SharedRoutingModule } from './shared-routing.module';
import { TableLayoutComponent } from './components/table-layout/table-layout.component';
import { FormDebugComponent } from './components/form-debug/form-debug.component';
import { CampoControlErroComponent } from './components/campo-control-erro/campo-control-erro.component';
import { ErrorMsgComponent } from './components/error-msg/error-msg.component';



@NgModule({
  declarations: [ 
    TableLayoutComponent,
    FormDebugComponent,
    CampoControlErroComponent,
    ErrorMsgComponent
   ],
  imports: [
    CommonModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule
  ],
  exports: [
    SharedRoutingModule,
    TableLayoutComponent,
    FormDebugComponent,
    CampoControlErroComponent,
    ErrorMsgComponent
  ]
})
export class SharedModule { }

