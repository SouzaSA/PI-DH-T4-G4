import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

import { map, tap } from 'rxjs/operators';

import { DisciplinaOferecidaMapper } from './../shared/mapper/disciplina-oferecida.mapper';
import { DisciplinaOferecidaDto } from './../shared/dto/disciplina-oferecida.dto';
import { environment } from './../../environments/environment';
import { ProfessorMapper } from './../shared/mapper/professor.mapper';
import { ProfessorDto } from './../shared/dto/professor.dto';
import { Professor } from './../shared/model/professor.model';
import { DisciplinaOferecida } from '../shared/model/disciplina-oferecida.model';
import { CursaDisciplinaOferecidaDto } from '../shared/dto/cursa-disciplina-oferecida.dto';

@Injectable({
  providedIn: 'root'
})
export class ProfessorService {

  private readonly API = `${environment.URLSERVIDOR}`;

  constructor( private http: HttpClient) { }

  getProfessorPorPessoaId(id: number)  {
    return this.http.get<ProfessorDto>(this.API+"professores/pessoa/"+id)
    .pipe(
      map((data: ProfessorDto) =>
        <Professor>ProfessorMapper.toProfessor(data),
      ),
      //tap(console.log)
    );
  }

  listaDisciplinasOferecidasPeloProfessor(id: number) {
    return this.http.get<DisciplinaOferecidaDto>(this.API+"disciplinaOferecidas/professor/" + id)
      .pipe(
        map((data: DisciplinaOferecidaDto) => 
          <DisciplinaOferecida>DisciplinaOferecidaMapper.toDisciplinaOferecida(data),
          ),
          tap(console.log)
      )
  }

  listaCursaDisciplinaOferecidaPeloProfessorId(id: number) {
    return this.http.get<CursaDisciplinaOferecidaDto[]>(this.API+"cursaDisciplinasOferecidas/professor/" + id);
  }

  listaCursaDisciplinaOferecidaPelaDisciplinaId(id: number) {
    return this.http.get<CursaDisciplinaOferecidaDto[]>(this.API+"cursaDisciplinasOferecidas/disciplina/" + id);
  }

  listaCursaDisciplinaOferecidaPelaDisciplinaIdEPeloProfessorId(disciplinaId: number, professorId: number) {
    return this.http.get<CursaDisciplinaOferecidaDto[]>(this.API+"cursaDisciplinasOferecidas/disciplina/" + disciplinaId +"/professor/" + professorId);
  }
}
