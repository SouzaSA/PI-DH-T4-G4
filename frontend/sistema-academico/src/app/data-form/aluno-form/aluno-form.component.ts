import { Component, OnInit, TemplateRef } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';

import { BsModalService, BsModalRef } from 'ngx-bootstrap/modal'; 

import { AdministradorService } from './../../service/administrador.service';

@Component({
  selector: 'app-aluno-form',
  templateUrl: './aluno-form.component.html',
  styleUrls: ['./aluno-form.component.css']
})
export class AlunoFormComponent implements OnInit {

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
      pessoaRequest: [null],
      alunoId: [null],
      curso: this.formBuilder.group({
        cursoId: [null],
        nome: [null]
      })
    });

  }

  openModalWithClass(cadastroAluno: TemplateRef<any>) {  
    this.modalRef = this.modalService.show(  
      cadastroAluno,  
      Object.assign({}, { class: 'gray modal-lg' })  
    );  
  }

  onSubmit() {
    console.log(this.formulario.value);

    this.administradorService.postAluno(this.formulario.value).subscribe();
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
