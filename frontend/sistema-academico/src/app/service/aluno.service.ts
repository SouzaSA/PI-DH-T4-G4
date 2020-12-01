import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

import { map, tap } from 'rxjs/operators';

import { AlunoMapper } from './../shared/mapper/aluno.mapper';
import { environment } from './../../environments/environment';
import { AlunoDto } from '../shared/dto/aluno.dto';
import { Aluno } from './../shared/model/aluno.model';
import { CursaDisciplinaOferecidaDto } from '../shared/dto/cursa-disciplina-oferecida.dto';


@Injectable({
  providedIn: 'root'
})
export class AlunoService {

  private readonly API = `${environment.URLSERVIDOR}`;

  constructor( private http: HttpClient) { }

  getAlunoPorPessoaId(id: number)  {
    return this.http.get<AlunoDto>(this.API+"alunos/pessoa/"+id)
    .pipe(
      map((data: AlunoDto) =>
        <Aluno>AlunoMapper.toAluno(data)
      ),
      tap(console.log)
    );
  }

  getCursaDisciplinaOferecida(id: number) {
    return this.http.get<CursaDisciplinaOferecidaDto[]>(this.API+"cursaDisciplinasOferecidas/aluno/"+id)
  }
}
