import { FormBuilder, Validators, FormGroup } from '@angular/forms';
import { AuthService } from './../service/auth.service';
import { Component, OnInit, TemplateRef } from '@angular/core';  
import { BsModalService, BsModalRef } from 'ngx-bootstrap/modal';  

@Component({  
  selector: 'login-modal-popup',  
  templateUrl: './login-modal.component.html',  
  styleUrls: ['./login-modal.component.css']  
})  
export class LoginModalComponent implements OnInit {  

  modalRef: BsModalRef; 
  public formulario: FormGroup;

  constructor(
    private modalService: BsModalService,
    private authService: AuthService,
    private fb: FormBuilder
  ) { }  
  
  ngOnInit() {  
    this.iniciarFormulario();
  }  

  openModalWithClass(template: TemplateRef<any>) {  
    this.modalRef = this.modalService.show(  
      template,  
      Object.assign({}, { class: 'gray modal-lg' })  
    );  
  }  

  public iniciarFormulario() {
    this.formulario = this.fb.group({
      login: ['', Validators.required],
      senha: ['', [Validators.required]]     
    });       
  }

  logar() {
    if (this.formulario.invalid) {
      return;
    }
    //fazer a chamada
    const login = this.formulario.value.login;
    const senha = this.formulario.value.senha;

    this.authService.login(login, senha);
    this.modalRef.hide();
  }

  logout() {
    this.authService.logout();
  }

  estaLogado() {
    return this.authService.isUserLoggedIn();
  }
}  