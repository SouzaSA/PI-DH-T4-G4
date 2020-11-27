import { ProfessorDto } from './../../shared/dto/professor.dto';
import { Component, OnInit, TemplateRef } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';

import { BsModalService, BsModalRef } from 'ngx-bootstrap/modal';

import { DropdownService } from 'src/app/service/dropdown.service';
import { SalaDto } from './../../shared/dto/sala.dto';
import { DisciplinaDto } from './../../shared/dto/disciplina.dto';
import { AdministradorService } from './../../service/administrador.service';

@Component({
  selector: 'disciplina-oferecida-form',
  templateUrl: './disciplina-oferecida-form.component.html',
  styleUrls: ['./disciplina-oferecida-form.component.css']
})
export class DisciplinaOferecidaFormComponent implements OnInit {

  formulario: FormGroup;

  modalRef: BsModalRef; 

  professores: ProfessorDto[];
  disciplinas: DisciplinaDto[];
  horarios: String[];
  dias: String[]; 
  salas: SalaDto[];


  constructor(
    private formBuilder: FormBuilder,
    private modalService: BsModalService,
    private dropdownService: DropdownService,
    private administradorService: AdministradorService
  ) { }

  ngOnInit(): void {
    this.formulario = this.formBuilder.group({
      disciplinaOferecidaId: [null],
      dia: [null],
      horario: [null],
      professor: [null],
      disciplina: [null],
      sala: [null],
      semestre: [null],
      turma: [null],
      ano: [null]
    });

    this.dropdownService.getHorarios().subscribe(dados => this.horarios = dados);
    
    this.dropdownService.getDias().subscribe(dados => this.dias = dados);

    this.dropdownService.getProfessores().subscribe(dados => this.professores = dados);

    this.dropdownService.getDisciplinas().subscribe(dados => this.disciplinas = dados);

    this.dropdownService.getSalas().subscribe(dados => this.salas = dados);


  }

  openModalWithClass(cadastroDisciplinaOferecida: TemplateRef<any>) {  
    this.modalRef = this.modalService.show(  
      cadastroDisciplinaOferecida,  
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
