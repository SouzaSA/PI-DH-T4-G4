import { Component, OnInit, TemplateRef } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';

import { BsModalService, BsModalRef } from 'ngx-bootstrap/modal'; 

import { AdministradorService } from './../../service/administrador.service';
@Component({
  selector: 'administrador-form',
  templateUrl: './administrador-form.component.html',
  styleUrls: ['./administrador-form.component.css']
})
export class AdministradorFormComponent implements OnInit {

  formulario: FormGroup;

  modalRef: BsModalRef; 

  constructor(
    private formBuilder: FormBuilder,
    private http: HttpClient,
    private modalService: BsModalService,
    private administradorService: AdministradorService
    ) { }

  ngOnInit(): void {

    this.formulario = this.formBuilder.group({
      pessoa: [null],
      administradorId: [null],
    });

  }

  openModalWithClass(cadastroAdministrador: TemplateRef<any>) {  
    this.modalRef = this.modalService.show(  
      cadastroAdministrador,  
      Object.assign({}, { class: 'gray modal-lg' })  
    );  
  }

  onSubmit() {
    console.log(this.formulario.value);

    this.administradorService.postAdministrador(this.formulario.value).subscribe();
  }

  resetar(){
    this.formulario.reset();
  }

  cancel(){
    this.resetar();
    this.modalRef.hide();
  }

  verificaValidTouched(campo){

    return !this.formulario.get(campo).valid && this.formulario.get(campo).touched;

  }

  aplicaCssErro(campo){
    return{
      'has-error': this.verificaValidTouched(campo),
      'has-feedback': this.verificaValidTouched(campo)
    }
  }
}
