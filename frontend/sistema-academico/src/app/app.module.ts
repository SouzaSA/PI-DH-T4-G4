import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import { ModalModule } from 'ngx-bootstrap/modal'; 

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginModalComponent } from './login-modal/login-modal.component';
import { MenuLateralComponent } from './menu-lateral/menu-lateral.component';
import { InformesGeralComponent } from './informes-geral/informes-geral.component';
import { InformesDepartamentoComponent } from './informes-departamento/informes-departamento.component';
import { ProfessorComponent } from './professor/professor.component';
import { DadosPessaisComponent } from './dados-pessais/dados-pessais.component';
import { GerenciaInformesComponent } from './professor/gerencia-informes/gerencia-informes.component'; 



@NgModule({
  declarations: [
    AppComponent,
    LoginModalComponent,
    MenuLateralComponent,
    InformesGeralComponent,
    InformesDepartamentoComponent,
    ProfessorComponent,
    DadosPessaisComponent,
    GerenciaInformesComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    ModalModule.forRoot(),  
    FormsModule,  
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
