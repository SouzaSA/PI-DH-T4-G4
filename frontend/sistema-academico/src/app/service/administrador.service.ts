import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

import { tap } from 'rxjs/operators';

import { Aluno } from '../model/aluno.model';

@Injectable()
export class AdministradorService {

  private readonly API = 'http://localhost:3000/';

  constructor( private http: HttpClient) { }

  listarAlunos() {
    return this.http.get<Aluno[]>(this.API+"aluno")
    .pipe(
      tap()
    );
  }
}