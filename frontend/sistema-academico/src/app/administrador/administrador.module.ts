
import { NgModule } from '@angular/core';

import { NgbModule } from '@ng-bootstrap/ng-bootstrap';

import { SharedModule } from '../shared/shared.module';
import { AdministradorComponent } from './administrador.component';
import { AdministradorService } from '../service/administrador.service'
import { CadastroAlunosComponent } from './cadastro-alunos/cadastro-alunos.component';
import { MenuAdmItensComponent } from './menu-adm-itens/menu-adm-itens.component';
import { MenuItensCadastroComponent } from './menu-itens-cadastro/menu-itens-cadastro.component';

@NgModule({
  declarations: [
    AdministradorComponent, 
    CadastroAlunosComponent,
    MenuAdmItensComponent,
    MenuItensCadastroComponent
  ],
  imports: [ SharedModule, NgbModule ],
  providers: [ AdministradorService ],
  exports: [ 
    AdministradorComponent, 
    CadastroAlunosComponent,
    MenuAdmItensComponent,
    MenuItensCadastroComponent 
  ]
})
export class AdministradorModule { }