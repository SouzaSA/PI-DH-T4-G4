import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

import { ModalModule } from 'ngx-bootstrap/modal'; 

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginModalComponent } from './login-modal/login-modal.component';
import { MenuLateralComponent } from './menu-lateral/menu-lateral.component'; 

@NgModule({
  declarations: [
    AppComponent,
    LoginModalComponent,
    MenuLateralComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ModalModule.forRoot(),  
    FormsModule,  
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
