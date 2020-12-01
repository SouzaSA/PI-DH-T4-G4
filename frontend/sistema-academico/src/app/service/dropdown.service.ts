import { tap } from 'rxjs/operators';
import { SalaDto } from './../shared/dto/sala.dto';
import { DisciplinaDto } from './../shared/dto/disciplina.dto';
import { ProfessorDto } from './../shared/dto/professor.dto';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

import { environment } from './../../environments/environment';
import { EstadoBr } from './../shared/model/estado-br.model';
import { Cidade } from '../shared/model/cidade';

@Injectable({
  providedIn: 'root'
})
export class DropdownService {

  private readonly API = `${environment.URLSERVIDOR}`;

  constructor(private http: HttpClient) {}

  getEstadosBr() {
    return this.http.get<EstadoBr[]>('https://servicodados.ibge.gov.br/api/v1/localidades/estados');
  }

  getCidades(idEstado: number) {
    return this.http.get<Cidade[]>(`https://servicodados.ibge.gov.br/api/v1/localidades/estados/${idEstado}/municipios`);
    // .pipe(
    //   // tslint:disable-next-line:triple-equals
    //   map((cidades: Cidade[]) => cidades.filter(c => c.estado == idEstado))
    // );
  }

  getHorarios () {
    return this.http.get<string[]>(`${this.API}enums/horarios`);
  }

  getDias () {
    return this.http.get<string[]>(`${this.API}enums/dias`);
  }

  getProfessores () {
    return this.http.get<ProfessorDto[]>(`${this.API}professores`);
  }

  getDisciplinas () {
    return this.http.get<DisciplinaDto[]>(`${this.API}disciplinas`);
  }

  getSalas () {
    return this.http.get<SalaDto[]>(`${this.API}salas`);
  }
}
