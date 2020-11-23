import { Component, forwardRef, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { FormGroup, FormBuilder, Validators, ControlValueAccessor, Validator, ValidationErrors, AbstractControl, NG_VALUE_ACCESSOR, NG_VALIDATORS } from '@angular/forms';
import { TelefoneDto } from 'src/app/shared/dto/telefone.dto';

@Component({
  selector: 'pessoa-form',
  templateUrl: './pessoa-form.component.html',
  styleUrls: ['./pessoa-form.component.css'],
  providers: [
    {
      provide: NG_VALUE_ACCESSOR,
      useExisting: forwardRef(() => PessoaFormComponent),
      multi: true
    },
     {
      provide: NG_VALIDATORS,
      useExisting: forwardRef(() => PessoaFormComponent),
      multi: true
    }
  ]
})
export class PessoaFormComponent implements OnInit, ControlValueAccessor, Validator {

  public pessoaForm: FormGroup = this.formBuilder.group({
    pessoaId: [null],
    nome: [null, Validators.required],
    sobrenome: [null, Validators.required],
    email: [null, Validators.required],
    endereco: [null],
    telefones: [null]
  });

  constructor(private formBuilder: FormBuilder) { }

  ngOnInit(): void {
  }

  public onTouched: () => void = () => {};

  writeValue(val: any): void {
    val && this.pessoaForm.setValue(val, { emitEvent: false });
  }
  
  registerOnChange(fn: any): void {
    this.pessoaForm.valueChanges.subscribe(fn);
  }

  registerOnTouched(fn: any): void {
    this.onTouched = fn;
  }

  setDisabledState?(isDisabled: boolean): void {
    isDisabled ? this.pessoaForm.disable() : this.pessoaForm.enable();
  }

  validate(c: AbstractControl): ValidationErrors | null{
    return this.pessoaForm.valid ? null : { invalidForm: {valid: false, message: "Endereço inválido"}};
  }

}
