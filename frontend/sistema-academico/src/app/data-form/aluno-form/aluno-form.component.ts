import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators, FormControl } from '@angular/forms';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-aluno-form',
  templateUrl: './aluno-form.component.html',
  styleUrls: ['./aluno-form.component.css']
})
export class AlunoFormComponent implements OnInit {

  formulario: FormGroup;

  constructor(
    private formBuilder: FormBuilder,
    private http: HttpClient
    ) { }

  ngOnInit(): void {

    this.formulario = this.formBuilder.group({
      pessoaRequest: [null],
    });

  }

  onSubmit() {
    console.log(this.formulario.value);

    this.http.post('https:/httpbin.org/post', 
                    JSON.stringify(this.formulario.value))
      .subscribe(dados => {
        //console.log(dados);
        // reseta o form
        this.formulario.reset();
      });
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
