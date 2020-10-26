import { Component, OnInit, TemplateRef } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';

import { BsModalService, BsModalRef } from 'ngx-bootstrap/modal'; 

import { AdministradorService } from './../../service/administrador.service';

@Component({
  selector: 'sala-form',
  templateUrl: './sala-form.component.html',
  styleUrls: ['./sala-form.component.css']
})
export class SalaFormComponent implements OnInit {

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
      salaId: [null],
      numero: [null],
      departamento: [null],
      capacidade: [null],
      andar: [null]
    });

  }

  openModalWithClass(cadastroSala: TemplateRef<any>) {  
    this.modalRef = this.modalService.show(  
      cadastroSala,  
      Object.assign({}, { class: 'gray modal-lg' })  
    );  
  }

  onSubmit() {
    console.log(this.formulario.value);

    this.administradorService.postSala(this.formulario.value).subscribe();
  }

  resetar(){
    this.formulario.reset();
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
