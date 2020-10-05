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
import { GerenciaInformesCreateComponent } from './professor/gerencia-informes/gerencia-informes-create/gerencia-informes-create.component';
import { GerenciaInformesReadComponent } from './professor/gerencia-informes/gerencia-informes-read/gerencia-informes-read.component';
import { GerenciaInformesUpdateComponent } from './professor/gerencia-informes/gerencia-informes-update/gerencia-informes-update.component';
import { GerenciaInformesDeleteComponent } from './professor/gerencia-informes/gerencia-informes-delete/gerencia-informes-delete.component';

import { MatExpansionModule } from '@angular/material/expansion';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatIconModule } from '@angular/material/icon';
import { MatSnackBarModule } from '@angular/material/snack-bar';
import { MatSelectModule } from '@angular/material/select';
import { MatTableModule } from '@angular/material/table';
import { MatPaginatorModule } from '@angular/material/paginator';
import { MatSortModule } from '@angular/material/sort';
import { MatDialogModule } from '@angular/material/dialog';
import { MatCardModule } from '@angular/material/card';

import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

import { EditorModule } from 'primeng/editor';
import { CardModule } from 'primeng/card';
import { ButtonModule } from 'primeng/button';
import { DynamicDialogModule } from 'primeng/dynamicdialog';
import { DropdownModule } from 'primeng/dropdown';
import { InputTextModule } from 'primeng/inputtext';
import { DialogModule } from 'primeng/dialog';


@NgModule({
  declarations: [
    AppComponent,
    LoginModalComponent,
    MenuLateralComponent,
    InformesGeralComponent,
    InformesDepartamentoComponent,
    ProfessorComponent,
    DadosPessaisComponent,
    GerenciaInformesComponent,
    GerenciaInformesCreateComponent,
    GerenciaInformesReadComponent,
    GerenciaInformesUpdateComponent,
    GerenciaInformesDeleteComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    ModalModule.forRoot(),
    FormsModule,
    ReactiveFormsModule,
    MatExpansionModule,
    BrowserAnimationsModule,
    MatFormFieldModule,
    EditorModule,
    CardModule,
    ButtonModule,
    MatIconModule,
    DynamicDialogModule,
    DropdownModule,
    MatSnackBarModule,
    MatSelectModule,
    MatTableModule,
    MatSortModule,
    MatPaginatorModule,
    MatDialogModule,
    MatCardModule,
    InputTextModule,
    DialogModule
   
  ],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
