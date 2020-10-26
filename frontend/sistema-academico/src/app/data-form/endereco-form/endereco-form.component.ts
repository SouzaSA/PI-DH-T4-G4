import { Component, forwardRef, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { FormGroup, FormBuilder, Validators, ControlValueAccessor, Validator, ValidationErrors, AbstractControl, NG_VALUE_ACCESSOR, NG_VALIDATORS } from '@angular/forms';

@Component({
  selector: 'endereco-form',
  templateUrl: './endereco-form.component.html',
  styleUrls: ['./endereco-form.component.css'],
  providers: [
    {
      provide: NG_VALUE_ACCESSOR,
      useExisting: forwardRef(() => EnderecoFormComponent),
      multi: true
    },
     {
      provide: NG_VALIDATORS,
      useExisting: forwardRef(() => EnderecoFormComponent),
      multi: true
    }
  ]
})
export class EnderecoFormComponent implements OnInit, ControlValueAccessor, Validator {

  public enderecoForm: FormGroup = this.formBuilder.group({
    //id: [null],
    cep: [null, Validators.required],
    rua: [null, Validators.required],
    numero: [null, Validators.required],
    bairro: [null, Validators.required],
    complemento: [null],
    cidade: [null, Validators.required],
    estado: [null, Validators.required]
  });
  

  constructor(
    private formBuilder: FormBuilder,
    private http: HttpClient
    ) { }

  ngOnInit(): void {

  }

  public onTouched: () => void = () => {};

  writeValue(val: any): void {
    val && this.enderecoForm.setValue(val, { emitEvent: false });
  }
  registerOnChange(fn: any): void {
    this.enderecoForm.valueChanges.subscribe(fn);
  }
  registerOnTouched(fn: any): void {
    this.onTouched = fn;
  }
  setDisabledState?(isDisabled: boolean): void {
    isDisabled ? this.enderecoForm.disable() : this.enderecoForm.enable();
  }

  validate(c: AbstractControl): ValidationErrors | null{
    return this.enderecoForm.valid ? null : { invalidForm: {valid: false, message: "Endereço inválido"}};
  }

}
