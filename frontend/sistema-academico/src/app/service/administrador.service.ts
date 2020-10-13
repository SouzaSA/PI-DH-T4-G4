import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

import { tap } from 'rxjs/operators';

import { Aluno } from '../model/aluno.model';
import { Administrador } from '../model/administrador.model';
import { Professor } from './../model/professor.model';

@Injectable()
export class AdministradorService {

  private readonly API = 'http://localhost:3000/';

  constructor( private http: HttpClient) { }

  listarAlunos() {
    return this.http.get<Aluno[]>(this.API+"aluno")
    .pipe(
      tap(console.log)
    );
  }

  listarAdministradores() {
    return this.http.get<Professor[]>(this.API+"administrador")
    .pipe(
      tap(console.log)
    );
  }

  listarProfessores() {
    return this.http.get<Administrador[]>(this.API+"professor")
    .pipe(
      tap(console.log)
    );
  }
}