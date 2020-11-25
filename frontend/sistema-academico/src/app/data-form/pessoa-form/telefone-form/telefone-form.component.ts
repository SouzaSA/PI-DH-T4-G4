import { Component, forwardRef, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, FormArray, NG_VALUE_ACCESSOR, NG_VALIDATORS, AbstractControl, ValidationErrors } from '@angular/forms';

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

  public telefonesForm: FormGroup = this.formBuilder.group({
    telefones: this.formBuilder.array([])
  });

  constructor(private formBuilder: FormBuilder) {}

  ngOnInit(): void {
    this.addTelefone();
  }

  get telefones() {
    return this.telefonesForm.get('telefones') as FormArray;
  }

  newTelefone(): FormGroup {
    return this.formBuilder.group({
      telefoneId: '',
      telefone: '',
    })
  }

  addTelefone() {
    this.telefones.push(this.newTelefone());
  }
   
  removeTelefone(i:number) {
    this.telefones.removeAt(i);
  }

  public onTouched: () => void = () => {};

  writeValue(val: any): void {
    val && this.telefonesForm.setValue(val, { emitEvent: false });
  }
  registerOnChange(fn: any): void {
    this.telefonesForm.valueChanges.subscribe(fn);
  }
  registerOnTouched(fn: any): void {
    this.onTouched = fn;
  }
  setDisabledState?(isDisabled: boolean): void {
    isDisabled ? this.telefonesForm.disable() : this.telefonesForm.enable();
  }

  validate(c: AbstractControl): ValidationErrors | null{
    return this.telefonesForm.valid ? null : { invalidForm: {valid: false, message: "Telefone inválido"}};
  }

}
