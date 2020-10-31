import { Component, OnInit, TemplateRef, ElementRef, ViewChild } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';

import { Subscription } from 'rxjs';

import { BsModalService, BsModalRef } from 'ngx-bootstrap/modal'; 

import { AdministradorService } from './../../service/administrador.service';
import { SharedService } from './../../service/shared.service';

@Component({
  selector: 'professor-form',
  templateUrl: './professor-form.component.html',
  styleUrls: ['./professor-form.component.css']
})
export class ProfessorFormComponent implements OnInit {

  @ViewChild('cadastroProfessor') modalProfessor: ElementRef;

  editEventSubscription: Subscription;

  formulario: FormGroup;

  modalRef: BsModalRef; 

  constructor(
    private formBuilder: FormBuilder,
    private http: HttpClient,
    private modalService: BsModalService,
    private administradorService: AdministradorService,
    private sharedService: SharedService
    ) {
      this.editEventSubscription = this.sharedService.getEditEvent().subscribe((datum)=>{
        
        this.editarProfessor(datum)
      })
    }

  ngOnInit(): void {

    this.formulario = this.formBuilder.group({
      pessoaRequest: [null],
      departamento: [null],
      professorId: [null]
    });

  }



  openModalWithClass(cadastroProfessor: TemplateRef<any>) {
    console.log(cadastroProfessor);
    console.log(this.modalProfessor);

    this.modalRef = this.modalService.show(  
      cadastroProfessor,  
      Object.assign({}, { class: 'gray modal-lg' })  
    );  
  }

  editarProfessor(datum: number){
    this.modalRef = this.modalService.show(  
      this.modalProfessor,  
      Object.assign({}, { class: 'gray modal-lg' })  
    );
    this.administradorService.getProfessorePorId(datum).subscribe(professor => {
      this.formulario.patchValue({
        professorId: professor.professorId,
        departamento: professor.departamento,
        pessoaRequest: { 
          pessoaId: professor.pessoaId,
          nome: professor.nome,
          sobrenome: professor.sobrenome,
          email: professor.email,
          endereco: {
            id: professor.enderecoId,
            cep: professor.cep,
            rua: professor.rua,
            numero: professor.numero,
            complemento: professor.complemento,
            bairro: professor.bairro,
            cidade: professor.cidade,
            estado: professor.estado
          }
        }

      })
    })
  }

  onSubmit() {
    console.log(this.formulario.value);
    if (this.formulario.value.professorId == null || this.formulario.value.professorId == undefined){
      this.administradorService.postProfessor(this.formulario.value).subscribe();
    }
    else {
      //this.administradorService.putProfessor(this.formulario.value, this.formulario.value.professorId).subscribe();
    }
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
