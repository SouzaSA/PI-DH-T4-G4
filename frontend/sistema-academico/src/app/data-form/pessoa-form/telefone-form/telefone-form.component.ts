import { Component, forwardRef, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, FormArray, NG_VALUE_ACCESSOR, NG_VALIDATORS } from '@angular/forms';

import { TelefoneDto } from './../../../shared/dto/telefone.dto';

@Component({
  selector: 'telefone-form',
  templateUrl: './telefone-form.component.html',
  styleUrls: ['./telefone-form.component.css'],
  providers: [
    {
      provide: NG_VALUE_ACCESSOR,
      useExisting: forwardRef(() => TelefoneFormComponent),
      multi: true
    },
     {
      provide: NG_VALIDATORS,
      useExisting: forwardRef(() => TelefoneFormComponent),
      multi: true
    }
  ]
})
export class TelefoneFormComponent implements OnInit {

  telefonesForm: FormGroup;

  constructor(private formBuilder: FormBuilder) { 
    this.telefonesForm = this.formBuilder.group({
      name: '',
      telefones: this.formBuilder.array([])
    });
  }

  ngOnInit(): void {
    this.addTelefone();
  }

  telefones() {
    return this.telefonesForm.get('telefones') as FormArray;
  }

  newTelefone(): FormGroup {
    return this.formBuilder.group({
      telefoneId: '',
      telefone: '',
    })
  }

  addTelefone() {
    this.telefones().push(this.newTelefone());
  }
   
  removeTelefone(i:number) {
    console.log("cagamba");
    this.telefones().removeAt(i);
  }

}