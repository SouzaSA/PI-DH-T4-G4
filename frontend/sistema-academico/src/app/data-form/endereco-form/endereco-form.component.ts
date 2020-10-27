import { Component, forwardRef, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { FormGroup, FormBuilder, Validators, ControlValueAccessor, Validator, ValidationErrors, AbstractControl, NG_VALUE_ACCESSOR, NG_VALIDATORS } from '@angular/forms';

import { distinctUntilChanged, switchMap, tap, map } from 'rxjs/operators';
import { empty } from 'rxjs';

import { Cidade } from './../../shared/model/cidade';
import { EstadoBr } from './../../shared/model/estado-br.model';
import { DropdownService } from './../../service/dropdown.service';
import { ConsultaCepService } from './../../service/consulta-cep.service';
import { FormValidations } from './../../shared/form-validations';


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

  estados: EstadoBr[];
  cidades: Cidade[];

  public enderecoForm: FormGroup = this.formBuilder.group({
    id: [null],
    cep: [null, [Validators.required, FormValidations.cepValidator]],
    rua: [null, Validators.required],
    numero: [null, Validators.required],
    bairro: [null, Validators.required],
    complemento: [null],
    cidade: [null, Validators.required],
    estado: [null, Validators.required]
  });
  

  constructor(
    private formBuilder: FormBuilder,
    private http: HttpClient,
    private dropdownService: DropdownService,
    private cepService: ConsultaCepService,
    ) { }

  ngOnInit(): void {
    this.dropdownService.getEstadosBr()
      .subscribe(dados => this.estados = dados);

    this.enderecoForm.get('cep').statusChanges
    .pipe(
      distinctUntilChanged(),
      tap(value => console.log('status CEP:', value)),
      switchMap(status => status === 'VALID' ?
        this.cepService.consultaCEP(this.enderecoForm.get('cep').value)
        : empty()
      )
    )
    .subscribe(dados => dados ? this.populaDadosForm(dados) : {});

    this.enderecoForm.get('estado').valueChanges
      .pipe(
        tap(estado => console.log('Novo estado: ', estado)),
        map(estado => this.estados.filter(e => e.sigla === estado)),
        map(estados => estados && estados.length > 0 ? estados[0].id : empty()),
        switchMap((estadoId: number) => this.dropdownService.getCidades(estadoId)),
        tap(
          //console.log
        )
      )
      .subscribe(cidades => this.cidades = cidades);
  }


  consultaCEP() {
    const cep = this.enderecoForm.get('cep').value;

    if (cep != null && cep !== '') {
      this.cepService.consultaCEP(cep)
      .subscribe(dados => this.populaDadosForm(dados));
    }
  }

  populaDadosForm(dados) {
    this.enderecoForm.patchValue({
        rua: dados.logradouro,
        complemento: dados.complemento,
        bairro: dados.bairro,
        cidade: dados.localidade,
        estado: dados.uf
    });
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
