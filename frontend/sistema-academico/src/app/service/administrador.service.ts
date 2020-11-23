
import { DisciplinaOferecidaMapper } from './../shared/mapper/disciplina-ferecida.mapper';
import { DisciplinaOferecidaDto } from './../shared/dto/disciplina-oferecida.dto';
import { Professor } from './../shared/model/professor.model';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

import { map, take, tap } from 'rxjs/operators';

import { environment } from './../../environments/environment';
import { ProfessorDto } from '../shared/dto/professor.dto';
import { AlunoDto } from '../shared/dto/aluno.dto';
import { AlunoMapper } from '../shared/mapper/aluno.mapper';
import { AdministradorMapper } from '../shared/mapper/administrador.mapper';
import { ProfessorMapper } from '../shared/mapper/professor.mapper';
import { AdministradorDto } from '../shared/dto/administrador.dto';
import { DisciplinaDto } from '../shared/dto/disciplina.dto';
import { SalaDto } from '../shared/dto/sala.dto';
import { Administrador } from '../shared/model/administrador.model';

@Injectable()
export class AdministradorService {

  private readonly API = `${environment.URLSERVIDOR}`;

  constructor( private http: HttpClient) { }

  getAdministradorPorPessoaId(id: number)  {
    return this.http.get<AdministradorDto>(this.API+"administradores/pessoa/"+id)
    .pipe(
      map((data: AdministradorDto) =>
        <Administrador>AdministradorMapper.toAdministrador(data)
      ),
      tap(console.log)
    );
  }

  listarAlunos() {
    return this.http.get<AlunoDto[]>(this.API+"alunos")
    .pipe(
      map((data: AlunoDto[]) =>
          data.map(
            (item: AlunoDto) =>
              AlunoMapper.toAluno(item),
          )
        )
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
      ),
      tap(console.log)
    );
  }

  listarAdministradores() {
    return this.http.get<AdministradorDto[]>(this.API+"administradores")
    .pipe(
      map((data: AdministradorDto[]) =>
        data.map(
          (item: AdministradorDto) =>
            AdministradorMapper.toAdministrador(item),
        )
      )
     
    );
  }

  listarDisciplinas() {
    return this.http.get<DisciplinaDto[]>(this.API+"disciplinas")
    .pipe(
      tap()
    );
  }

  listarSalas() {
    return this.http.get<SalaDto[]>(this.API+"salas")
    .pipe(
      tap()
    );
  }

  listarDisciplinasOferecidas() {
    return this.http.get<DisciplinaOferecidaDto[]>(this.API+"disciplinaOferecidas")
    .pipe(
      map((data: DisciplinaOferecidaDto[]) =>
        data.map(
          (item: DisciplinaOferecidaDto) =>
            DisciplinaOferecidaMapper.toDisciplinaOferecida(item),
        )
      ),
      tap(console.log)
    );
  }

  getProfessorePorId(id: number)  {
    return this.http.get<ProfessorDto>(this.API+"professores/"+id)
    .pipe(
      map((data: ProfessorDto) =>
        <Professor>ProfessorMapper.toProfessor(data),
      )
    );
  }

  postProfessor(professorData) {
    console.log(JSON.stringify(professorData));
    return this.http.post(this.API+"professores", professorData)
      .pipe(take(1));
  }

  postAluno(alunoData) {
    console.log(JSON.stringify(alunoData));
    return this.http.post(this.API+"alunos", alunoData)
      .pipe(take(1));
  
  }

  postAdministrador(administradorData) {
    console.log(JSON.stringify(administradorData));
    return this.http.post(this.API+"administradores", administradorData)
      .pipe(take(1));
  
  }

  postSala(salaData) {
    console.log(JSON.stringify(salaData));
    return this.http.post(this.API+"salas", salaData)
      .pipe(take(1));
  
  }

  postDisciplina(disciplinaData) {
    console.log(JSON.stringify(disciplinaData));
    return this.http.post(this.API+"disciplinas", disciplinaData)
      .pipe(take(1));
  
  }

  putProfessor(professorData, id) {
    console.log(JSON.stringify(professorData));
    return this.http.put(this.API+"professores"+"/"+id, professorData)
      .pipe(take(1));
  }

}