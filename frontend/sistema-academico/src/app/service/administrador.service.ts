import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

import { map, take, tap } from 'rxjs/operators';

import { Aluno } from '../shared/model/aluno.model';
import { Administrador } from '../shared/model/administrador.model';
import { Professor } from '../shared/model/professor.model';
import { ProfessorMapper } from '../shared/mapper/professor.mapper';
import { ProfessorDto } from '../shared/dto/professor.dto';

@Injectable()
export class AdministradorService {

  private readonly API = 'http://localhost:3000/';

  constructor( private http: HttpClient) { }

  listarAlunos() {
    return this.http.get<Aluno[]>(this.API+"alunos")
    .pipe(
      tap(console.log)
    );
  }

  listarProfessores()  {
    return this.http.get<ProfessorDto[]>(this.API+"professores")
    .pipe(
      map((data: ProfessorDto[]) =>
          data.map(
            (item: ProfessorDto) =>
              ProfessorMapper.toProfessor(item),
          )
        )
    );
  }

  postProfessor(professorData) {
    console.log(JSON.stringify(professorData));
    return this.http.post(this.API+"professores", professorData)
      .pipe(take(1));
  
  }

  listarAdministradores() {
    return this.http.get<Administrador[]>(this.API+"administradores")
    .pipe(
      tap(console.log)
     
    );
  }
}