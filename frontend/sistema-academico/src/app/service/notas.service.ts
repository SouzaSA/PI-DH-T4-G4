import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Aluno, Disciplina, Turma } from '../professor/notas/notas.model';

@Injectable({ providedIn: 'root' })
export class NotasService {
  constructor(private http: HttpClient) {}

  baseUrl = 'http://localhost:3000/turmas';

  getTurma(): Observable<Turma[]> {
    return this.http.get<Turma[]>(this.baseUrl);
  }
}
