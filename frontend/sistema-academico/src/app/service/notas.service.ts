import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

import { Observable } from 'rxjs';
import { Aluno, Disciplina, Turma } from '../professor/notas/notas.model';
import { environment } from './../../environments/environment';

@Injectable({ providedIn: 'root' })
export class NotasService {
  constructor(private http: HttpClient) {}

  baseUrl = `${environment.URLSERVIDOR}`+'turmas';
  apiUrl = `${environment.URLSERVIDOR}`+'disciplinas';

  getTurma(): Observable<Turma[]> {
    return this.http.get<Turma[]>(this.baseUrl);
  }

  getDisciplina(): Observable<Disciplina[]> {
    return this.http.get<Disciplina[]>(this.apiUrl);
  }

  atualizarTurma(turma: Turma): Observable<Turma> {
    const url = `${this.baseUrl}/${turma.id}`;
    return this.http.put<Turma>(url, turma);
  }
}
