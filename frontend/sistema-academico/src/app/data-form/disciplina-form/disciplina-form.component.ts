import { Component, OnInit, TemplateRef } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';

import { BsModalService, BsModalRef } from 'ngx-bootstrap/modal'; 

import { AdministradorService } from './../../service/administrador.service';

@Component({
  selector: 'disciplina-form',
  templateUrl: './disciplina-form.component.html',
  styleUrls: ['./disciplina-form.component.css']
})
export class DisciplinaFormComponent implements OnInit {

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
      disciplinaId: [null],
      codigo: [null],
      creditos: [null],
      ementa: [null],
      nome: [null],
      requeridas: [null],
      semestreIdeal: [null]
    });
  }

  openModalWithClass(cadastroDisciplina: TemplateRef<any>) {  
    this.modalRef = this.modalService.show(  
      cadastroDisciplina,  
      Object.assign({}, { class: 'gray modal-lg' })  
    );  
  }

  onSubmit() {
    console.log(this.formulario.value);

    this.administradorService.postDisciplina(this.formulario.value).subscribe();
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
