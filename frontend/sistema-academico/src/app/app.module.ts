import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import { ModalModule } from 'ngx-bootstrap/modal';

import { NotasComponent } from './professor/notas/notas.component';
import { AdministradorModule } from './administrador/administrador.module';
import { AlunoModule } from './aluno/aluno.module';
import { ProfessorModule } from './professor/professor.module';
import { SharedModule } from './shared/shared.module';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginModalComponent } from './login-modal/login-modal.component';
import { MenuLateralComponent } from './menu-lateral/menu-lateral.component';
import { InformesGeralComponent } from './informes-geral/informes-geral.component';
import { InformesDepartamentoComponent } from './informes-departamento/informes-departamento.component';
import { ProfessorComponent } from './professor/professor.component';
import { httpInterceptorProviders } from './shared/http-interceptors/index';

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
import { DataFormModule } from './data-form/data-form.module';

import { GerenciaNotasComponent } from './professor/notas/gerencia-notas/gerencia-notas.component';
import { TableModule } from 'primeng/table';
import { AccordionModule } from 'primeng/accordion';
import { KeyFilterModule } from 'primeng/keyfilter';
import { MenuProfItensComponent } from './professor/menu-prof-itens/menu-prof-itens.component';
import { InputNumberModule } from 'primeng/inputnumber';
import { PaginatorModule } from 'primeng/paginator';
import { GerenciaInformesComponent } from './professor/informes/gerencia-informes/gerencia-informes.component';
import { InformesComponent } from './professor/informes/informes.component';
import { CadastroInformesComponent } from './professor/informes/cadastro-informes/cadastro-informes.component';
import { CadastroAvaliacaoComponent } from './professor/notas/cadastro-avaliacao/cadastro-avaliacao.component';
import { CalendarModule } from 'primeng/calendar';

@NgModule({
  declarations: [
    AppComponent,
    LoginModalComponent,
    MenuLateralComponent,
    InformesGeralComponent,
    InformesDepartamentoComponent,
    ProfessorComponent,
    GerenciaInformesComponent,
    GerenciaNotasComponent,
    NotasComponent,
    MenuProfItensComponent,
    InformesComponent,
    CadastroInformesComponent,
    CadastroAvaliacaoComponent
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
    DialogModule,
    AdministradorModule,
    SharedModule,
    ProfessorModule,
    DataFormModule,
    AlunoModule,
    TableModule,
    AccordionModule,
    KeyFilterModule,
    InputNumberModule,
    PaginatorModule,
    CalendarModule,
  ],
  providers: [httpInterceptorProviders],
  bootstrap: [AppComponent],
})
export class AppModule {}
