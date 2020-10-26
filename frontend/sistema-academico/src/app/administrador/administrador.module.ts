import { CommonModule } from '@angular/common';

import { NgModule } from '@angular/core';

import { NgbModule } from '@ng-bootstrap/ng-bootstrap';

import { SharedModule } from '../shared/shared.module';
import { AdministradorComponent } from './administrador.component';
import { AdministradorService } from '../service/administrador.service'
import { CadastroAlunosComponent } from './cadastro-alunos/cadastro-alunos.component';
import { MenuAdmItensComponent } from './menu-adm-itens/menu-adm-itens.component';
import { MenuItensCadastroComponent } from './menu-itens-cadastro/menu-itens-cadastro.component';
import { CadastroProfessoresComponent } from './cadastro-professores/cadastro-professores.component';
import { CadastroAdministradoresComponent } from './cadastro-administradores/cadastro-administradores.component';
import { DataFormModule } from '../data-form/data-form.module';
import { CadastroSalasComponent } from './cadastro-salas/cadastro-salas.component';
import { CadastroDisciplinasComponent } from './cadastro-disciplinas/cadastro-disciplinas.component';

@NgModule({
  declarations: [
    AdministradorComponent, 
    CadastroAlunosComponent,
    MenuAdmItensComponent,
    MenuItensCadastroComponent,
    CadastroProfessoresComponent,
    CadastroAdministradoresComponent,
    CadastroSalasComponent,
    CadastroDisciplinasComponent
  ],
  imports: [ 
    NgbModule,
    CommonModule,
    SharedModule, 
    DataFormModule 
  ],
  providers: [ AdministradorService ],
  exports: [ 
    AdministradorComponent, 
    CadastroAlunosComponent,
    MenuAdmItensComponent,
    MenuItensCadastroComponent 
  ]
})
export class AdministradorModule { }