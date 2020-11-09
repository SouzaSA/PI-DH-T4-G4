import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

import { map, tap } from 'rxjs/operators';

import { environment } from './../../environments/environment';
import { ProfessorMapper } from './../shared/mapper/professor.mapper';
import { ProfessorDto } from './../shared/dto/professor.dto';
import { Professor } from './../shared/model/professor.model';

@Injectable({
  providedIn: 'root'
})
export class ProfessorService {

  private readonly API = `${environment.URLSERVIDOR}`;

  constructor( private http: HttpClient) { }

  getProfessorePorPessoaId(id: number)  {
    return this.http.get<ProfessorDto>(this.API+"professores/pessoa/"+id)
    .pipe(
      map((data: ProfessorDto) =>
        <Professor>ProfessorMapper.toProfessor(data),
      ),
      tap(console.log)
    );
  }

}
