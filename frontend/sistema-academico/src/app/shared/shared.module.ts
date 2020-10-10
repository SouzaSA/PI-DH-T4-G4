import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { SharedRoutingModule } from './shared-routing.module';
import { TableLayoutComponent } from './components/table-layout/table-layout.component';

@NgModule({
  declarations: [ TableLayoutComponent ],
  imports: [
    CommonModule
  ],
  exports: [
    SharedRoutingModule,
    TableLayoutComponent
  ]
})
export class SharedModule { }

